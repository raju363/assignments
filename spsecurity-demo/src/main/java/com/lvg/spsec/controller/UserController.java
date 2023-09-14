package com.lvg.spsec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvg.spsec.Entity.Employee;
import com.lvg.spsec.Entity.Users;
import com.lvg.spsec.Service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	UserService userService;
	 @GetMapping(produces="application/Json")
	  public ResponseEntity<Users> getUSerById(String name){
		Users user=userService.getByUsername(name);
		if(user!=null) return new ResponseEntity<Users>(user,HttpStatus.OK);

		return new ResponseEntity<Users>(user,HttpStatus.NOT_FOUND);
		 
	 }
	 @PostMapping(produces="application/Json")
	 public HttpStatus insertintoUser( Users users){
		   if(userService.insertorModify(users))
				return  HttpStatus.OK;
				   return HttpStatus.NOT_MODIFIED;

		 
	 }
	 @PutMapping(produces="application/Json")
	 public HttpStatus deleteUser(@PathVariable String name) {
		   if(userService.delete(name))
				return  HttpStatus.OK;
				   return HttpStatus.NOT_MODIFIED; 
	 }
}
