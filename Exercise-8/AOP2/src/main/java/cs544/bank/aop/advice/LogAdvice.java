package cs544.bank.aop.advice;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import cs544.bank.logging.ILogger;



@Aspect
public class LogAdvice {
	
	private ILogger logger;
	
	public LogAdvice(ILogger logger) {
		this.logger = logger;
	}
	
	 @After("execution(* cs544.bank.dao.AccountDAO.*(..))")
	 public void logAfterMethodCall(JoinPoint joinpoint) {
		 String msg = "after execution of AccountDAO method "+joinpoint.getSignature().getName();
		 this.logger.log(msg);
	 }
	 
	 @After("execution(* cs544.bank.jms.JMSSender.*(..))")
	 public void logAfterJMSCall(JoinPoint joinpoint) {
		 String msg = "after execution of JMS method "+joinpoint.getSignature().getName();
		 this.logger.log(msg);
	 }
	 
	// @Around("execution(* cs544.bank.service(..))")
	@Around("execution(* cs544.bank.service.*.*(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {

		StopWatch clock = new StopWatch("");
		 clock.start(call.toShortString());
		 Object object= call.proceed();
		 clock.stop();
		 this.logger.log(clock.prettyPrint());
		 //System.out.println();
		 return object;

	}

}
