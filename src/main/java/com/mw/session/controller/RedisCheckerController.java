package com.mw.session.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RedisCheckerController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/hello")
	public String hello(HttpSession session) {
		session.setAttribute("hello", "eric");
		return "hello eric!";
	}
	
    @GetMapping("/")
    public String root(HttpSession session) {
    	logger.info("session.getId()                  = " + session.getId());
    	logger.info("session.getLastAccessedTime()    = " + session.getLastAccessedTime());
    	logger.info("session.getMaxInactiveInterval() = " + session.getMaxInactiveInterval());
    	
    	return "/ - SessionID " + session.getId();
    }
    
    @GetMapping("/admin")
    public String admin(HttpSession session) {
    	logger.info("session.getId()                  = " + session.getId());
    	logger.info("session.getLastAccessedTime()    = " + session.getLastAccessedTime());
    	logger.info("session.getMaxInactiveInterval() = " + session.getMaxInactiveInterval());
    	
    	return "/admin - SessionID " + session.getId();
    }
    
    @GetMapping("/user")
    public String user(HttpSession session) {
    	logger.info("session.getId()                  = " + session.getId());
    	logger.info("session.getLastAccessedTime()    = " + session.getLastAccessedTime());
    	logger.info("session.getMaxInactiveInterval() = " + session.getMaxInactiveInterval());
    	
    	return "/user - SessionID " + session.getId();
    }
    
    @GetMapping("/p069528")
    public String p069528(HttpSession session) {
    	logger.info("session.getId()                  = " + session.getId());
    	logger.info("session.getLastAccessedTime()    = " + session.getLastAccessedTime());
    	logger.info("session.getMaxInactiveInterval() = " + session.getMaxInactiveInterval());
    	
    	return "/p069528 - SessionID " + session.getId();
    }
    
}
