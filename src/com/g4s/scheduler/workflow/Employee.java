package com.g4s.scheduler.workflow;

public class Employee {

	private OpCode opCode;
	private String employeeInfo;
	
	public Employee() {
		
	}
	
	public Employee(OpCode opCode, String employeeInfo) {
		this.opCode=opCode;
		this.employeeInfo=employeeInfo;
	}

	public OpCode getOpCode() {
		return opCode;
	}

	public void setOpCode(OpCode opCode) {
		this.opCode = opCode;
	}

	public String getEmployeeInfo() {
		return employeeInfo;
	}

	public void setAssignment(String employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
}
