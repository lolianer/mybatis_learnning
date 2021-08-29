package com.swz.mybatis.service.impl;

import com.swz.mybatis.bean.Employee;
import com.swz.mybatis.dao.EmployeeMapper;
import com.swz.mybatis.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shen_wzhong
 * @create 2021-08-28 9:53
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<Employee> getEmps() {
        return employeeMapper.getEmps();
    }
}
