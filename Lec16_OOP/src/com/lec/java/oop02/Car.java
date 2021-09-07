package com.lec.java.oop02;

public class Car extends Vehicle {
	private int oil;
	private Tire[] tire = new Tire[4];  // Has-a 관계는 멤버로 설계

	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}
	
	@Override
	public String toString() {
		String out = "--- Car 정보---\nspeed: " + getSpeed() + "\noil: " + oil;
		return out;
	}
}
