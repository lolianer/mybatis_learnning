package com.swz.mybatis.dao;

import com.swz.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //返回一条记录的map；key就是列名，值就是对应的值
    Employee  getEmployeeById(Integer id);

    List<Employee> getEmps();


}
