package com.mscourse.hruser.user.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mscourse.hruser.user.User;
import com.mscourse.hruser.user.UserRepository;


@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserREST {

	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/search")
	public ResponseEntity<Optional<User>> findById(@RequestParam String email){		
		return ResponseEntity.ok(repository.findByEmail(email));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Long id){		
		return ResponseEntity.ok(repository.findById(id));
	}
	
}
