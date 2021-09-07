package com.lec.java.oop02;

public class HybridCar extends Car {
	private int electricity;

	public int getElectricity() {
		return electricity;
	}

	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}
	
	@Override
	public String toString() {
		String out = "--- HybridCar 정보---\nspeed: "
				+ getSpeed() + "\noil: " + getOil()
				+ "\nelectricity: " + electricity;
		return out;
	}
}
