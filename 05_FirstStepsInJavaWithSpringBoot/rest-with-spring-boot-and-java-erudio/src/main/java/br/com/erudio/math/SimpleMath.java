package br.com.erudio.math;

public class SimpleMath {
	public Double sum(Double numberOne, Double numberTwo ) {
		return numberOne + numberTwo;
	}
	
	public Double sub(Double numberOne, Double numberTwo ) {
		return numberOne - numberTwo;
	}
	
	public Double media(Double numberOne, Double numberTwo ) {
		return (numberOne + numberTwo) / 2;
	}
	
	public Double div(Double numberOne, Double numberTwo ) {
		return numberOne / numberTwo;
	}
	
	public Double square(Double numberOne) {
		return Math.sqrt(numberOne);
	}

	public Double multiplication(Double numberOne, Double numberTwo ) {
		return numberOne * numberTwo;
	}
}
