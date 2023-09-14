package com.lvg.spsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lvg.spsec.Entity.Employee;
import com.lvg.spsec.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
 @Autowired
 EmployeeService employeeservice;
 @Autowired
 PasswordEncoder passwordEncoder;
 
  @GetMapping(produces="application/json")
  @PostAuthorize("hasAuthority('ROLE_USER')")
  public ResponseEntity<List<Employee>> getallEmployee(){
	  return new  ResponseEntity<List<Employee>>(employeeservice.getAllEmployees(),HttpStatus.OK);
  }
  
  @GetMapping(value="/id/{employeeId}",produces="application/json")

	public ResponseEntity<Employee> getEmployeeById(@PathVariable int employeeId)

	{

		Employee e = employeeservice.getEmployeeById(employeeId);

		if(e!=null) return new ResponseEntity<Employee>(e,HttpStatus.OK);

		return new ResponseEntity<Employee>(e,HttpStatus.NOT_FOUND);

	}
    		
   @PostMapping(consumes="application/json")
  @PostAuthorize("hasAuthority('ROLE_ADMIN')")
   public HttpStatus addEmployee(@RequestBody Employee employee)
   {
//	   employee.setpassword(passwordEncoder.encode(employee.getpassword()));
	   if(employeeservice.insertorModify(employee))
	return  HttpStatus.OK;
	   return HttpStatus.NOT_MODIFIED;
   }

    @PutMapping(consumes="application/json")
    @PostAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus deleteEmployee(@PathVariable int id)
    {
 	   if(employeeservice.deleteByid(id))
 			return  HttpStatus.OK;
 			   return HttpStatus.NOT_MODIFIED;
    	
    }
}
