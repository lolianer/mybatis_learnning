package com.swz.mybatis.controller;

import com.swz.mybatis.bean.Employee;
import com.swz.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author shen_wzhong
 * @create 2021-08-28 9:49
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/getemps", method = RequestMethod.GET)
    public String getEmps(Model model) {
        List<Employee> emps = employeeService.getEmps();
        model.addAttribute("emps", emps);
        return "list";
    }
}
