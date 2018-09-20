package mum.cs.edu;



public class CalculatorServiceImpl implements CalculatorService {
	
	private static int result = 0;

	public int calculate(char operator, int value) {
		// TODO Auto-generated method stub
		
		switch(operator) {
		case '+':
			return result = result + value;
		case '-':
			return result = result - value;
		case '*':
			return result = result * value;
		case '/':
			return result = result / value;
		default:
			System.out.println("invalid operator");
			
		}
		return result;
	}

}
