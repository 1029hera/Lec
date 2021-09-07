package com.lec.java.class03;

public class Numeric {
	// 멤버변수
	private char ch;
	private byte operator;
	private int operand1;
	private int operand2;
	private boolean negetive;
	
	// 기본생성자
	public Numeric() {}
	
	// 매개변수 받는 생성자
	public Numeric(char ch, byte op, int opd1, int opd2) {
		super();
		this.ch = ch;
		this.setOperator(op);
		this.setOperand1(opd1);
		this.setOperand2(opd2);
	}
	
	
	// getter & setter
	
	public char getch() {
		return this.ch;
	}
	
	public void setch(char ch) {
		this.ch = ch;
	}

	public byte getOperator() {
		return operator;
	}

	public void setOperator(byte operator) {
		this.operator = operator;
	}

	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	public boolean isNegetive() {
		return negetive;
	}

	public void setNegetive(boolean negetive) {
		this.negetive = negetive;
	}

}
