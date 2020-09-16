package com.realpage;

import java.util.Stack;

public class InputProcessing {

	private Stack<Double> valuesStack = new Stack<Double>();
	private Stack<Operations> operatorStack = new Stack<Operations>();

	public void processInput(String input) {

		String[] result = input.split("\\s");
		for (String aResult : result) {
			if (aResult != null && !aResult.trim().isEmpty()) {
				processToken(aResult);
			}
		}

	}

	public Stack<Double> getValuesStack() {
		return valuesStack;
	}

	private void processToken(String inputToken) {
		Double digit = parseDouble(inputToken);
		if (digit == null) {
			Operations s = Operations.getOperation(inputToken);
			if (s != null) {
				operatorStack.push(s);
			}
		} else {
			valuesStack.push(digit);
		}
		// System.out.println(operatorStack.size()+" opsize");
		if (valuesStack.size() >= 2 && operatorStack.size() > 0) {
			Double one = valuesStack.pop();
			Double two = valuesStack.pop();
			Operations cal = operatorStack.pop();
			try {
			Double three = cal.calculate(one, two);
			if(!three.isInfinite() && !three.isNaN()) {
			// valuesStack.clear();
			operatorStack.clear();
			valuesStack.push(three);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Double parseDouble(String token) {
		Double digit;
		try {
			digit = Double.parseDouble(token);
		} catch (Exception e) {
			digit = null;
		}
		return digit;
	}

	

}
