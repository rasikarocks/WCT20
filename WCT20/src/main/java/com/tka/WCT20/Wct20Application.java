package com.tka.WCT20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
@EnableAspectJAutoProxy
public class Wct20Application {

	public static void main(String[] args) {
		SpringApplication.run(Wct20Application.class, args);
	}

}
