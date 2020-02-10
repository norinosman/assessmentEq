package com.norin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import com.norin.service.EmployeeService;
@Controller
public class EmployeeDeleteController  {
@CrossOrigin(origins = "*" )	
@RequestMapping(method = RequestMethod.DELETE, value="/delete/employee/{empNum}")
@ResponseBody
public String deleteEmployeeRecord(@PathVariable("empNum") String empNum)   throws Exception{
	System.out.println("DeleteEmployeeRecord");   
	EmployeeService employeeService = new EmployeeService();
	employeeService.deleteEmployeeById(empNum);

    return null;
}
}