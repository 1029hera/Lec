package com.lec.java.static03;

public class Test {
	private int num;
	
	public Test() {
		num = 100;
	}
	
	private static Test instance = null;
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test(); //  인스턴스 생성
		}
		return instance;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	

}
