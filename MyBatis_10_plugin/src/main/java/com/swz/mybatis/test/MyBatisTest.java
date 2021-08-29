package com.swz.mybatis.test;

import com.swz.mybatis.bean.Employee;
import com.swz.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
	
	public SqlSessionFactory getSqlSessionfactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	@Test
	public void test2() throws IOException {
		//1.获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionfactory = getSqlSessionfactory();

		//2.获取sqlSession对象
		SqlSession openSession = sqlSessionfactory.openSession();

		Employee employee;
		try {
			//3.获取接口的实现对象
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

			employee = mapper.getEmployeeById(1);
			System.out.println(mapper.getClass());
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}

}
