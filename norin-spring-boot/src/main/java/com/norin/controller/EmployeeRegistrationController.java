package com.norin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.norin.beans.Employee;
import com.norin.service.EmployeeService;
import com.norin.models.EmployeeEntity;

@Controller
public class EmployeeRegistrationController {
  @CrossOrigin(origins = "*" )
  @RequestMapping(method = RequestMethod.POST, value="/register/employee")
  @ResponseBody
  public EmployeeEntity addEmployee(@RequestBody Employee employee) throws Exception{
	  System.out.println("Employee Registration");
		EmployeeService employeeService = new EmployeeService();
		EmployeeEntity employeeEntity = new EmployeeEntity();	  
        try {
	  		employeeEntity.setEmail(employee.getEmail());
	  		employeeEntity.setEmployeeNumber(employee.getEmployeeNumber());
	  		employeeEntity.setIcNumber(employee.getIcNumber());
	  		employeeEntity.setName(employee.getName());
	  		employeeService.saveEmployee(employeeEntity);
        }
        catch(Exception e) {
        	employeeEntity =  null;
        }

        return employeeEntity;
 }
}