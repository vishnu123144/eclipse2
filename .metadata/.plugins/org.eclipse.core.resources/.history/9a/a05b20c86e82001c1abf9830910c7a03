package com.brillio.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {

	Factorial fact;
	@Test
	public void testForValidData() {
		fact=new Factorial();
	    assertEquals(120, fact.factorial(5));
	    assertEquals(1, fact.factorial(0));
	    assertEquals(1, fact.factorial(1));
	
	}
	
	@Test
	public void testForInvalidValidData() {
		fact=new Factorial();
	    assertEquals(-1, fact.factorial(-5));
	   
	
	}
}
