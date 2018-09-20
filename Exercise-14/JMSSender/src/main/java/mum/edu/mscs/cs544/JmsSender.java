package mum.edu.mscs.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class JmsSender {
	@Autowired
	JmsTemplate jmsTemplate;

	public void sendJMSMessage(Calculate calcObj) {
		System.out.println("Sending a JMS message.");
		jmsTemplate.convertAndSend("calculatorQueue", calcObj);
	}
}
