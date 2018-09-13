package cs544.exercise16_1.bank.jms;

import org.springframework.stereotype.Service;

@Service
public class JMSSender implements IJMSSender{
	
	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
