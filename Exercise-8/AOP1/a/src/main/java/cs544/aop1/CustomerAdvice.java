package cs544.aop1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CustomerAdvice {	
	@After("execution(* cs544.aop1.EmailSender.sendEmail(..))")
	public void logEmailEvent(JoinPoint joinpoint){
		System.out.println(new Date() + " method= sendMail");
	}
}
