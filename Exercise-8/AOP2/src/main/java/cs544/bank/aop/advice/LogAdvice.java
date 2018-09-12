package cs544.bank.aop.advice;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;



@Aspect
public class LogAdvice {
	 @After("execution(* cs544.bank.dao.AccountDAO.*(..))")
	 public void logAfterMethodCall(JoinPoint joinpoint) {
		 String msg = "after execution of method "+joinpoint.getSignature().getName();
	     //System.out.println("after execution of method "+joinpoint.getSignature().getName());
		 Logger.getLogger("LogAdvice").info(msg);
		//ogger.log(Level.INFO ".dfgdfgdfg.");
	 }

}
