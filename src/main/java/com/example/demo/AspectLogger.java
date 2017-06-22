package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class AspectLogger {

	@Before("within(com.example.demo..*)")
	public void logInicio(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
	//	String[] parametersToLog = method.getAnnotation(Loggeable.class).parameters();

		StringBuilder parameters = new StringBuilder();
		Loggeable loggeable = method.getAnnotation(Loggeable.class);
		System.out.println("method " + method + " loggeable " + loggeable);
		if(loggeable != null) {
			Object[] values = joinPoint.getArgs();
			String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();

			for (int i = 0; i < names.length; i++) {
				final String name = names[i];
				if (loggeable.value().contains(name)) {
					parameters.append(String.format(" %s:%s", names[i], values[i]));
				}
			}


		}
		long thread = Thread.currentThread().getId();
		System.out.println("[" + joinPoint + "][" + thread + "][BCI_INI] Start: " + parameters);
	}

	@AfterReturning("within(com.example.demo..*)")
	public void logFin(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		long thread = Thread.currentThread().getId();
		System.out.println("["+joinPoint+"]["+thread+"][BCI_FINOK]");
	}



}
