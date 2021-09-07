package com.lec.java.oop03;

public class Vehicle {
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	@Override
	public String toString() {
		String out = "--- Vehicle 정보---\nspeed: " + speed;
		return out;
	}
}
