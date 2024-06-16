package com.tka.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintHelloAdvice {
	@Before("execution(* com.tka.service.WCT20Service.fetchAllIndianCricketDepartmentCount())")
	public void printHello() {
		System.err.println("Hello");
	}
}
