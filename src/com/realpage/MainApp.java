package com.realpage;

import java.util.Scanner;
import java.util.Stack;

public class MainApp {
	
	
	public static void main(String args[]) {
		InputProcessing ip=new InputProcessing();
		Scanner in =new Scanner(System.in);
		 boolean keepRunning = true;
	        while (keepRunning) {
	        	String inputString = in.nextLine();
	            if ("q".equals(inputString)) {
	                keepRunning = false;
	            } else {
	               // System.out.println(inputString);
	                ip.processInput(inputString);
	                Stack<Double> stack = ip.getValuesStack();
	                if(!stack.isEmpty()) {
	                System.out.print(stack.lastElement()+"\n");
	                }
					
	            }
	    }
	        in.close();
	}
}


