package com.mscourse.hroauth.user;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mscourse.hroauth.feignclient.UserFeignClient;


@Service
public class UserService implements UserDetailsService {
	
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userFeignClient.findByEmail(username).getBody();
		if(user == null) {
			throw new IllegalArgumentException("Email não encontrado: " + username );
		}
		logger.info("Email: " + username);
		return user.get();
	}
}
