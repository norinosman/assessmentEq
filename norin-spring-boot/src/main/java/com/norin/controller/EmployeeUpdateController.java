package com.norin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.norin.beans.Employee;
import com.norin.models.EmployeeEntity;
import com.norin.service.EmployeeService;
@Controller
public class EmployeeUpdateController {
@CrossOrigin(origins = "*" )
@RequestMapping(method = RequestMethod.PUT, value="/update/employee")
@ResponseBody
public String updateEmployeeRecord(@RequestBody Employee employee)  throws Exception{
System.out.println("UpdateEmployeeRecord");   

	EmployeeService employeeService = new EmployeeService();
	EmployeeEntity employeeEntity = new EmployeeEntity();
	employeeEntity.setEmail(employee.getEmail());
	employeeEntity.setEmployeeNumber(employee.getEmployeeNumber());
	employeeEntity.setIcNumber(employee.getIcNumber());
	employeeEntity.setName(employee.getName());
	employeeService.createOrUpdateEmployee(employeeEntity);
    return null;
}
}
