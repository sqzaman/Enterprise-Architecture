package cs544.aop1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAdvice {	
	@After("execution(* cs544.aop1.EmailSender.sendEmail(..)) && args(email, message)")
	public void logEmailEvent(JoinPoint joinpoint, String email, String message){
		System.out.print(new Date() + " method= sendMail");
		System.out.print(" address= " + email);
		System.out.print(" message= " + message);
	}
}
