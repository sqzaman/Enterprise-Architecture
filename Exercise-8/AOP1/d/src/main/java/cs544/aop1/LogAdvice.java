package cs544.aop1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LogAdvice {	
	@After("execution(* cs544.aop1.EmailSender.sendEmail(..)) && args(email, message)")
	public void logEmailEvent(JoinPoint joinpoint, String email, String message){
		System.out.print(new Date() + " method= sendMail");
		System.out.print(" address= " + email);
		System.out.println(" message= " + message);		
		EmailSender emailSender = (EmailSender)joinpoint.getTarget();
		System.out.print("outgoing mail server = " + emailSender.outgoingMailServer);
		
	}
	@Around("execution(* cs544.aop1.CustomerDAO.save(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute save = " + totaltime + " ms");
		return retVal;
	}
}
