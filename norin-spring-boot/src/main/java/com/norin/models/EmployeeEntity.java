package com.norin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="employee")
public class EmployeeEntity {
 
    
    // -- @GeneratedValue
    
	@Id
	@Column(name="employee_number")
    private String employeeNumber;
     
    @Column(name="name")
    private String name;
     
    @Column(name="email")
    private String email;
     
    @Column(name="ic_number")
    private String icNumber;
     
    //Setters and getters
    
    
 
    @Override
    public String toString() {
        return "EmployeeEntity [employeeNumber=" + employeeNumber + ", name=" + name + 
                ", email=" + email + ", ic_number=" + icNumber  + "]";
    }

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIcNumber() {
		return icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}
}