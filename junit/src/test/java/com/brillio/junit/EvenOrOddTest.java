package com.brillio.junit;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class EvenOrOddTest {

	
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv",numLinesToSkip = 1)
	void evenOrOddTest(String input,String expected) {
		EvenOrOdd eoo=new EvenOrOdd();
		String actual=eoo.evenOrOdd(Integer.parseInt(input));
		assertEquals(expected, actual);
	}
}
