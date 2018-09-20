package mum.edu.mscs.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class JMSMessageListener {	
	
	private static int result = 0;

	public JMSMessageListener() {
		System.out.println(".....listening jms messages......"); 
	}



	@JmsListener(destination="calculatorQueue")
	public void receiveMessage(final Calculate calcObj) {
		System.out.println("Received" + calcObj);
		System.out.println("===================================");
		System.out.println(String.format("Previous value: %d, now got: %s, %d", result, calcObj.getOperator(), calcObj.getValue()));
		System.out.println(String.format("Result after calculate: %d", calculateMe(calcObj)));
		System.out.println("===================================");
	
		
	}
	
	static int calculateMe(Calculate calcObj) {
		switch (calcObj.getOperator()) {
		case '+':
			result = result + calcObj.getValue();
		case '-':
			result = result - calcObj.getValue();
		case '*':
			result = result * calcObj.getValue();
		case '/':
			result = result / calcObj.getValue();
		default:
		
		}
		
		return result;

	}
}
