package mum.edu.mscs.cs544;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;



@SpringBootApplication
@EnableJms
public class JmsSenderApplication implements CommandLineRunner {
	
	@Autowired
	private JmsSender jmsSender;

	public static void main(String[] args) {
		SpringApplication.run(JmsSenderApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("sending.....");
		jmsSender.sendJMSMessage(new Calculate('+', 100));
		jmsSender.sendJMSMessage(new Calculate('-', 20));
		jmsSender.sendJMSMessage(new Calculate('*', 5));
		jmsSender.sendJMSMessage(new Calculate('/', 5));
    }
	
	@Bean
	public JmsTemplate jmsTemplate(final ConnectionFactory connectionFactory) {
		final JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
		return jmsTemplate;
	}
	
	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}
