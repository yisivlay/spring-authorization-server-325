package com.example.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		var user1 = User.withDefaultPasswordEncoder().roles("admin").username("user1").password("pw").build();
		var user2 = User.withDefaultPasswordEncoder().roles("user").username("user2").password("pw").build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
}
