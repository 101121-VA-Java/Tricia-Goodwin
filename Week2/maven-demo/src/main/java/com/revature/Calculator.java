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
	
	public static double add(double x, double y) {
		return x+y;
	}
	
	public static double subtract(double x, double y) {
		return x-y;
	}
	
	public static double multiply(double x, double y) {
		return x*y;
	}
	
	public static double divide(double x, double y) {
		
		if (y == 0) {
			throw new CalculatorException("Dividing by Zero is not allowed.");
			
		}
		return x/y;
		
	}
	
	public static boolean isPrime(int i) {
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
public static void main(String[] Args){
	int a = 1;
	int b = 2;
	int c = 0;
	
	System.out.println(add(a,b));
	System.out.println(subtract(b,a));
	System.out.println(multiply(a,b));

	System.out.println(isPrime(9));
	System.out.println(divide(b,c));
	
}
}
