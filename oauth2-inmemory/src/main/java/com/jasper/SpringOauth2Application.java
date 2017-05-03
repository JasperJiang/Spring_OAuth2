package com.jasper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringOauth2Application.class, args);
	}
}
