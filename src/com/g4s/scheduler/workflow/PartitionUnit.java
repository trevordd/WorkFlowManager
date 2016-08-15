package com.g4s.scheduler.workflow;

import java.util.List;


public class PartitionUnit {

	private OpCode opCode;
	private List<Employee> employeeList;
	private List<ShiftAssignment> shiftAssignmentList;

	public PartitionUnit() {
		
	}


	public OpCode getOpCode() {
		return opCode;
	}

	public void setOpCode(OpCode opCode) {
		this.opCode = opCode;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}


	public List<ShiftAssignment> getShiftAssignmentList() {
		return shiftAssignmentList;
	}


	public void setShiftAssignmentList(List<ShiftAssignment> shiftAssignmentList) {
		this.shiftAssignmentList = shiftAssignmentList;
	}
	
}
