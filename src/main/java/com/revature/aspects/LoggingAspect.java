package com.revature.aspects;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	Logger log = Logger.getRootLogger();
	
	@Pointcut("execution(* com.revature.*.*.*(..))")
    public void allDeveloperMethods() {
    }
	
	@AfterThrowing(pointcut = "allDeveloperMethods()", throwing = "ex")
	public void logging(JoinPoint jp, Exception ex) {
		System.out.println("Exception!");
		log.trace(jp.getSignature() + " threw " + ex + "\n");
		log.trace("Stack Trace: " + ex.getStackTrace().toString());
	}
}