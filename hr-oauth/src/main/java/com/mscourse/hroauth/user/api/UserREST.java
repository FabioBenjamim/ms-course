package com.mscourse.hroauth.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mscourse.hroauth.user.User;
import com.mscourse.hroauth.user.UserService;

import feign.FeignException.NotFound;

@RestController
@RequestMapping(value = "/user")
public class UserREST {

	@Autowired
	private UserService repository; 
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {			
			return ResponseEntity.ok(repository.findByEmail(email));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
