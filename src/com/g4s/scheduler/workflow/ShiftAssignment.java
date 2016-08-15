package com.g4s.scheduler.workflow;

public class ShiftAssignment {

	private OpCode opCode;
	private String assignmentInfo;
	
	public ShiftAssignment() {
		
	}
	
	public ShiftAssignment(OpCode opCode, String assignment) {
		this.opCode=opCode;
		this.assignmentInfo=assignment;
	}

	public OpCode getOpCode() {
		return opCode;
	}

	public void setOpCode(OpCode opCode) {
		this.opCode = opCode;
	}

	public String getAssignment() {
		return assignmentInfo;
	}

	public void setAssignment(String assignment) {
		this.assignmentInfo = assignment;
	}
	
}
