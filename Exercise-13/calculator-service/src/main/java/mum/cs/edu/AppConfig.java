package mum.cs.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.support.RemoteExporter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class AppConfig {

  
    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorServiceImpl();
    }

    @Bean(name = "/CalculatorService")
    public RemoteExporter exporter() {
        HttpInvokerServiceExporter hse = new HttpInvokerServiceExporter();
        hse.setService(calculatorService());
        hse.setServiceInterface(CalculatorService.class);
        return hse;
    }
    
}