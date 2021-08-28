package com.swz.mybatis.service;

import com.swz.mybatis.bean.Employee;

import java.util.List;

/**
 * @author shen_wzhong
 * @create 2021-08-28 9:51
 */
public interface EmployeeService {
    List<Employee> getEmps();
}
