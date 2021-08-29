package com.swz.mybatis.test;

import com.swz.mybatis.bean.Employee;
import com.swz.mybatis.bean.EmployeeExample;
import com.swz.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shen_wzhong
 * @create 2021-08-28 16:13
 */
public class MyBatisTest {

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testMbg() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void testSimple() {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> list = mapper.selectByExample(null);
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testBatis3() {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            EmployeeExample employeeExample = new EmployeeExample();
            EmployeeExample.Criteria criteria = employeeExample.createCriteria();
            criteria.andLastNameLike("%e%");
            criteria.andGenderEqualTo("1");

            EmployeeExample.Criteria criteria1 = employeeExample.createCriteria();
            criteria1.andEmailLike("%e%");
            employeeExample.or(criteria1);

            List<Employee> list = mapper.selectByExample(employeeExample);
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
