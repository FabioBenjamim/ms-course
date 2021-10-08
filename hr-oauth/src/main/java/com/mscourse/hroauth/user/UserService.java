package com.mscourse.hroauth.user;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscourse.hroauth.feignclient.UserFeignClient;


@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		Optional<User> user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			throw new IllegalArgumentException("Email não encontrado: " + email );
		}
		logger.info("Email: " + email);
		return user.get();
	}
}
