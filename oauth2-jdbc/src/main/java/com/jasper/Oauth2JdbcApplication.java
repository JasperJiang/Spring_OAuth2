package com.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import javax.sql.DataSource;

@SpringBootApplication
public class Oauth2JdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2JdbcApplication.class, args);
	}

//
//	@Autowired
//	private DataSource dataSource;
//
//	@Autowired
//	public void init(AuthenticationManagerBuilder auth) throws Exception {
//		// @formatter:off
//		auth.jdbcAuthentication().dataSource(dataSource).withUser("test")
//				.password("123456").roles("USER", "ACTUATOR");
//		// @formatter:on
//	}

}
