package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;

public class CalculatorBean {
	
	@Autowired
	  private CalculatorService calculatorService;
	
	public int calculate(char operator, int value) {
        System.out.println("-- placing for calculate --");
        return calculatorService.calculate(operator, value);

    }

}
