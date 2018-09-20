package mum.edu.mscs.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class JMSMessageListener {	
	


	public JMSMessageListener() {
		System.out.println(".....listening jms messages......"); 
	}



	@JmsListener(destination="calculatorQueue")
	public void receiveMessage(final Calculate calcObj) {
		System.out.println("Received" + calcObj);
		System.out.println("===================================");
		System.out.println(String.format("Previous value: %d, now got: %s, %d", Calculator.getResult(), calcObj.getOperator(), calcObj.getValue()));
		System.out.println(String.format("Result after calculate: %d", Calculator.calculateMe(calcObj)));
		System.out.println("===================================");
	
		
	}
}
