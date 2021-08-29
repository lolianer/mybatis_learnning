package com.swz.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.swz.mybatis.bean.Employee;
import com.swz.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

		Page<Object> page = PageHelper.startPage(2, 5);
		//2.获取sqlSession对象
		SqlSession openSession = sqlSessionfactory.openSession();

		Employee employee;
		try {
			//3.获取接口的实现对象
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

			List<Employee> emps = mapper.getEmps();
			emps.forEach(System.out::println);
			System.out.println("当前页码：" + page.getPageNum());
			System.out.println("总记录数" + page.getTotal());
			System.out.println("每页记录数" + page.getPageSize());
			System.out.println("总页码" + page.getPages());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}

}
