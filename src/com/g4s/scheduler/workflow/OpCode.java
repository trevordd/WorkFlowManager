package com.g4s.scheduler.workflow;

public class OpCode {

	String opCodeId;
	
	public OpCode() {
		
	}
	
	public OpCode(String opCode) {
		this.opCodeId=opCode;
	}

	public String getOpCodeId() {
		return opCodeId;
	}

	public void setOpCode(String opCode) {
		this.opCodeId = opCode;
	}
	
	
}
