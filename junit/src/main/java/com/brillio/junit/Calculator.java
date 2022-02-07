package com.brillio.junit;

public class Calculator {
	
	public int addition(int x,int y) {
		if(x>=1 && y>=1) {
			return x+y;
		}
		return -1;
	}
	
	public int substraction(int x,int y) {
		return x-y;
	}

}
