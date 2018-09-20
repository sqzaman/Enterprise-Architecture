package com.logicbig.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class App {
	@Bean
	public CalculatorBean calculatorBean() {
		return new CalculatorBean();
	}

	@Bean
	public HttpInvokerProxyFactoryBean exporter() {
		HttpInvokerProxyFactoryBean b = new HttpInvokerProxyFactoryBean();
		b.setServiceUrl("http://localhost:8080/calculator-service/CalculatorService");
		b.setServiceInterface(CalculatorService.class);
		return b;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		CalculatorBean bean = context.getBean(CalculatorBean.class);
		System.out.println("adding 5 with initial 0: result should be 5 = " + bean.calculate('+', 5));
		
		System.out.println("multiplying 5 with previous 5: result should be 25 = " + bean.calculate('*', 5));
		
		System.out.println("subtracting 5 with previous 25: result should be 20 = " + bean.calculate('-', 5));
		
		System.out.println("deviding by 5 with previous 20: result should be 4 = " + bean.calculate('/', 5));
	}

}
