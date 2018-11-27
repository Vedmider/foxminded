package com.foxminded.integerDivision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IntegerDivisionTest {

	static IntegerDivision test;
	
	@BeforeAll
	public static void setUp() {
		test = new IntegerDivision();
	}
	
	
	@Test
	void testIntegerDivisionWithSimpleInts() {
		int dividend = 45;
		int divisor = 5;
		String expected = "_45|5\n"+
				          " 45|-\n"+
				          " --|9\n"+
				          "  0\n";
		String actual;
		
		actual = test.divide(dividend, divisor);
		assertEquals(expected, actual);	
	}
	
	@Test
	void testIllegalArgumentExceptionWhenDivisorIsZero() {
		int dividend = 50;
		int divisor = 0;
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.divide(dividend, divisor);
		});
	}
	
	@Test
	void testDivisionByOne() {
		int dividend = 33;
		int divisor = 1;
		String expected = "_33|1\n"+
						  "   |--\n"+
						  "   |33\n";
		String actual;
		
		actual = test.divide(dividend, divisor);
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testDivisionByItself() {
		int dividend = 547845;
		int divisor = 547845;
		String expected =
				"_547845|547845\n"+
				" 547845|------\n"+
				" ------|1\n"+
				"      0\n";
		String actual;
		
		actual = test.divide(dividend, divisor);
		assertEquals(expected, actual);	
	}
	
	@Test
	void testDivisionTwoWithSixDigits() {
		int dividend = 45;
		int divisor = 156648;
		String expected =
				"_45    |156648\n"+
				" 313296|-----------\n"+
				" ------|0.000287268\n"+
				"_1367040\n"+
				" 1253184\n"+
				" -------\n"+
				" _1138560\n"+
				"  1096536\n"+
				"  -------\n"+
				"   _420240\n"+
				"    313296\n"+
				"    ------\n"+
				"   _1069440\n"+
				"     939888\n"+
				"    -------\n"+
				"    _1295520\n"+
				"     1253184\n"+
				"     -------\n"+
				"       42336\n";
		String actual;
		
		actual = test.divide(dividend, divisor);
		assertEquals(expected, actual);	

	}
	
	@Test
	void testDivisionWithOneLoopedDigit() {
		int dividend = 1000;
		int divisor = 3;
		String expected = 
				"_1000|3\n"+
				"  9  |-------\n"+
				" --  |333.(3)\n"+
				" _10\n"+
				"   9\n"+
				"  --\n"+
				"  _10\n"+
				"    9\n"+
				"   --\n"+
				"   _10\n"+
				"     9\n"+
				"    --\n"+
				"     1\n";
		String actual;
		
		actual = test.divide(dividend, divisor);
		assertEquals(expected, actual);	

	}

}
