package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.exceptions.CalculatorException;

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	private static Calculator cal;

	@BeforeAll
	public static void setup() {
		cal = new Calculator();
	}




	@Test
	public void addOneAndOne() {
		double expected = 2;
		double actual = cal.add(1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void addFiveAndOne() {
		double expected = 6;
		double actual = cal.add(5, 1);
		assertEquals(expected, actual);
	}


	@Test
	public void addMinusTwoAndOne() {
		double expected = -1;
		double actual = cal.add(-2, 1);
		assertEquals(expected, actual);
	}
	

	@Test
	public void subtractOneAndOne() {
		double expected = 0;
		double actual = cal.subtract(1, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void subtractFiveAndOne() {
		double expected = 4;
		double actual = cal.subtract(5, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void subtractMinusTwoAndOne() {
		double expected = -3;
		double actual = cal.subtract(-2, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void multiplyThreeAndThree() {
		double expected = 9;
		double actual = cal.multiply(3, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void multiplyThreeAndZero() {
		double expected = 0;
		double actual = cal.multiply(3, 0);
		assertEquals(expected, actual);
	}

	@Test
	public void multiplyThreeAndMinusTwo() {
		double expected = -6;
		double actual = cal.multiply(3, -2);
		assertEquals(expected, actual);
	}

	@Test
	public void divideTwoByMinusTwo() {
		double expected = -1;
		double actual = cal.divide(2, -2);
		assertEquals(expected, actual);
	} 
	
	@Test
	public void divideTwelveByTwo() {
		double expected = 6;
		double actual = cal.divide(12, 2);
		assertEquals(expected, actual);
	} 
	
	@Test
	public void inThreePrime() {
		boolean expected = true;
		boolean actual = cal.isPrime(3);
		assertEquals(expected, actual);
	} 
	
	@Test
	public void isMinusSixPrime() {
		boolean expected = false;
		boolean actual = cal.isPrime(-6);
		assertEquals(expected, actual);
	} 

	
	@Test
	public void divideBy0() {

		
		assertThrows(CalculatorException.class, () -> cal.divide(1, 0));
		
	}

}
