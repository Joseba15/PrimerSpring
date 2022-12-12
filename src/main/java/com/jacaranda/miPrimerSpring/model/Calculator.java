package com.jacaranda.miPrimerSpring.model;

import java.util.Objects;

public class Calculator {

	
	private double numA;
	private double numB;
	
	
	public Calculator(double numA, double numB) {
		super();
		this.numA = numA;
		this.numB = numB;
	}

	public Calculator() {}

	public double getNumA() {
		return numA;
	}


	public void setNumA(double numA) {
		this.numA = numA;
	}


	public double getNumB() {
		return numB;
	}


	public void setNumB(double numB) {
		this.numB = numB;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numA, numB);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return Double.doubleToLongBits(numA) == Double.doubleToLongBits(other.numA)
				&& Double.doubleToLongBits(numB) == Double.doubleToLongBits(other.numB);
	}
	
	
	
	
}
