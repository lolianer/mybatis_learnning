package com.swz.mybatis.dao;

import com.swz.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapper {


    Employee getEmployeeById(Integer id);
    List<Employee> getEmps();

}
