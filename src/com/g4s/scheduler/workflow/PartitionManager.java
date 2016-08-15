package com.g4s.scheduler.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionManager {

	private List<ShiftAssignment> shiftAssignments;
	private List<Employee> employees;
	
	private Map<OpCode,List<Employee>> employeeOpcodeMap;
	private Map<OpCode,List<ShiftAssignment>> shiftAssignmentOpcodeMap;
	private List<PartitionUnit> partitionUnits;
	

	public PartitionManager(List<ShiftAssignment> shiftAssignments, List<Employee> employees) {
		this.shiftAssignments=shiftAssignments;
		this.employees=employees;
		
		employeeOpcodeMap=new HashMap<OpCode, List<Employee>>();
		shiftAssignmentOpcodeMap=new HashMap<OpCode, List<ShiftAssignment>>();
		partitionUnits=new ArrayList<PartitionUnit>();
	}

	
	public void partition() {	
		this.partitionShiftAssignments (shiftAssignments);
		this.partitionEmployees(employees);		
		
		//TODO add logger
		System.out.println("Number of Unique OpCodes for Employees : " + employeeOpcodeMap.size());
		System.out.println("Number of Unique OpCodes for ShiftAssignments : " + shiftAssignmentOpcodeMap.size());
		
		for (OpCode opCode : shiftAssignmentOpcodeMap.keySet()) {
			PartitionUnit pUnit = new PartitionUnit();
			pUnit.setOpCode(opCode);
			pUnit.setEmployeeList(employeeOpcodeMap.get(opCode));
			pUnit.setShiftAssignmentList(shiftAssignmentOpcodeMap.get(opCode));
			
			System.out.println("\nCreated Partition Unit for OpCode :" + opCode.getOpCodeId());
			System.out.println("Employees : " + pUnit.getEmployeeList().size() + " | ShiftAssignments : " + 
							pUnit.getShiftAssignmentList().size());
			
			this.partitionUnits.add(pUnit);
		}
	}
		
	
	private void partitionShiftAssignments(List<ShiftAssignment> shiftAssignments) {		
		for (ShiftAssignment sa : shiftAssignments) {
			if (!shiftAssignmentOpcodeMap.containsKey(sa.getOpCode())) {
				shiftAssignmentOpcodeMap.put(sa.getOpCode(),new ArrayList<ShiftAssignment>());
			}
			
			shiftAssignmentOpcodeMap.get(sa.getOpCode()).add(sa);
		}	
	}
	
	
	private void partitionEmployees(List<Employee> employee) {		
		for (Employee emp : employee) {
			if (!employeeOpcodeMap.containsKey(emp.getOpCode())) {
				employeeOpcodeMap.put(emp.getOpCode(),new ArrayList<Employee>());
			}		
			employeeOpcodeMap.get(emp.getOpCode()).add(emp);
		}	
	}
	

	
	public List<ShiftAssignment> getShiftAssignments() {
		return shiftAssignments;
	}

	public void setShiftAssignments(List<ShiftAssignment> shiftAssignments) {
		this.shiftAssignments = shiftAssignments;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public List<PartitionUnit> getPartitionUnits() {
		return partitionUnits;
	}
	
	
	
	
}
