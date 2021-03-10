package com.cg.empmgt.controllers;

import java.util.List;
import com.cg.empmgt.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.empmgt.entities.*;
import com.cg.empmgt.service.*;
import com.cg.empmgt.util.*;

@RequestMapping("/employee")
@RestController
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private EmployeeUtil util;
	
	@GetMapping(value = "byId/{id}")
	public EmployeeDetails fetchEmpoyee(@PathVariable("id") Integer employeeId) {
		Employee employee = service.findById(employeeId);
		EmployeeDetails details=util.toDetails(employee);
		return details;
	}
	
	@GetMapping
	public List<EmployeeDetails> fetchAllEmployee(){
		List<Employee> list = service.findAll();
		List<EmployeeDetails>desiredList = util.toDetailsList(list);
		return desiredList;
	}
	
	@PostMapping("/add")
    public String addEmployee(@RequestBody CreateEmployeeRequest requestData) {
        Employee create = service.add(requestData.getName(), requestData.getDepartment());
        return "Created employee with id=" + create.getId();
    }
	
	@PutMapping("/changename")
    public EmployeeDetails changeName(@RequestBody ChangeNameRequest requestData) {
        Employee employee = service.updateName(requestData.getId(), requestData.getName());
        EmployeeDetails desiredList = util.toDetails(employee);
        return desiredList;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteEmployeeRequest requestData){
        service.removeById(requestData.getId());
        return "Employee deleted for id="+requestData.getId();
    }
	
	

}
