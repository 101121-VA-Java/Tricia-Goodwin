package com.revature;

import com.revature.exceptions.CalculatorException;

public class Calculator {

	/*
	 * Should be able to
	 * 	- add
	 * 	- subtract
	 * 	- multiply
	 * 	- divide
	 * 		- throw Calculator Exception (Runtime) when attempting to divide by 0
	 *	- isPrime: checks if a number is Prime
	 */
	
	public double add(double x, double y) {
		return x+y;
	}
	
	public double subtract(double x, double y) {
		return x-y;
	}
	
	public double multiply(double x, double y) {
		return x*y;
	}
	
	public double divide(double x, double y) {
		
		if (y == 0) {
			throw new CalculatorException("Dividing by Zero is not allowed.");
			
		}
		return x/y;
		
	}
	
	public boolean isPrime(int i) {
		boolean ans = false;
		if(i==0||i==1) {
			ans = false;
		} else if (i==2) {
			ans = true;
		} else {
			for(int j = 2; j<i; j++) {
				if(i%j == 0) {
					ans = false;
				} else {
					ans = true;
				}

			}
		}
		return ans;
	}

}
