package com.mw.session;

// https://pasudo123.tistory.com/379

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
public class RedisSessionCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisSessionCheckerApplication.class, args);
	}
}
