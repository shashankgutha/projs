package com.realpage;

import java.util.HashMap;
import java.util.Map;

public enum Operations implements CalcuatorInterface {

	ADD("+") {
		public Double calculate(Double firstDigit, Double secondDigit) {
			return secondDigit + firstDigit;
		}
	},
	SUB("-") {
		public Double calculate(Double firstDigit, Double secondDigit) {
			return secondDigit - firstDigit;
		}
	},
	MUL("*") {
		public Double calculate(Double firstDigit, Double secondDigit) {
			return secondDigit * firstDigit;
		}
	},
	DIV("/") {
		public Double calculate(Double firstDigit, Double secondDigit) {
			return secondDigit / firstDigit;
		}
	};
	
	private String token;
	
	
	private Operations(String token) {
		this.token = token;
	}

	private static Map<String,Operations> operations=new HashMap<String,Operations>();
	
	static {
		for(Operations opr:Operations.values()) {
			operations.put(opr.token, opr);
		}
	}
	
	public static Operations getOperation(String operator) {
		return operations.get(operator);
	}

	/*
	 * public static Operations parseOperator(String operator) { switch (operator) {
	 * case "+": return ADD; case "-": return SUB; case "*": return MUL; case "/":
	 * return DIV; default: return null; }
	 * 
	 * }
	 */

}
