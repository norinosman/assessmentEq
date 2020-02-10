package com.norin.controller;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.norin.beans.Employee;
import com.norin.service.EmployeeService;
import com.norin.models.EmployeeEntity;

@Controller
public class EmployeeRetrieveController {
	  @CrossOrigin(origins = "*" )
	  @RequestMapping(method = RequestMethod.GET, value="/employee/allemployee")
	  @ResponseBody
	  public List<Employee> getAllEmployees() {
		  EmployeeService employeeService = new EmployeeService();
		  List<EmployeeEntity> listEmpEntity=  employeeService.getAllEmployees();
		  
		  List<Employee> listEmployee =  new ArrayList<Employee>();
		  for(int i=0;i < listEmpEntity.size(); i++) {
			  EmployeeEntity empEntity = (EmployeeEntity) listEmpEntity.get(i);
			  Employee employee = new Employee();

			  employee.setEmail(empEntity.getEmail());
			  employee.setEmployeeNumber(empEntity.getEmployeeNumber());
			  employee.setIcNumber(empEntity.getIcNumber());
			  employee.setName(empEntity.getName());
			 
			  listEmployee.add(employee);
		
		  }
		  System.out.println("Employee List size :" + listEmployee.size() );
		 return listEmployee;
		  
	  }

}

