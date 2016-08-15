package com.g4s.scheduler.workflow;

import java.util.ArrayList;
import java.util.List;

public class WorkFlowManager {

	private WorkFlowProperties wfProps;
	
	/**
	 * Options (currently)
	 * 1) Partitioning ON OR OFF
	 * 2) Pattern ON or OFF
	 * 3) Run1 ON or OFF
	 * 4) Run2 ON or OFF
	 * 
	 * @param wfProps
	 */
	public WorkFlowManager (WorkFlowProperties wfProps) {
		this.wfProps = wfProps;
	}
	
	
	/**
	 * @param shiftAssignments
	 * @param employees
	 */

	public void process(List<ShiftAssignment> shiftAssignments, List<Employee> employees) {
		List<SolutionResult> allSolutionsList = new ArrayList<SolutionResult>();
		
		if (!wfProps.isDoPartitioning()) {
			SolutionResult sr = this.processRun1Pipeline(shiftAssignments, employees);
			allSolutionsList.add(sr);
			
		} else {
			
			PartitionManager partitionManager = new PartitionManager(shiftAssignments, employees);
			partitionManager.partition();
			
			System.out.println("\n>>> Processing : " + partitionManager.getPartitionUnits().size() + " partition units");
			
			// for each opcode - process
			// here we will eventually create new threads for each partition unit
			// including calculating time allocations dependent on data size
			
			List<SolutionResult> partitionSolutionResults = new ArrayList<SolutionResult>();
			
			for (PartitionUnit pUnit : partitionManager.getPartitionUnits()) {
				SolutionResult sr = this.processIndividualPartition(pUnit);
				partitionSolutionResults.add(sr);
			}
			
			// 'merge' results		
			for (SolutionResult partitionedSolutionResult : partitionSolutionResults) {
				allSolutionsList.add(partitionedSolutionResult);
			}
		}
	
		// run 2
		if (wfProps.isDoRun2()) {			
			this.processRun2Pipeline(allSolutionsList);	
		} else {
			System.out.println("\n\n**** Ignoring Processing run 2 pipeline"); 			
		}
	}	
	
	
	/**
	 * 
	 * @param partitionUnit
	 * @return
	 */
	private SolutionResult processIndividualPartition(PartitionUnit partitionUnit) {
		
		if (partitionUnit.getOpCode() != null  && (!partitionUnit.getOpCode().getOpCodeId().isEmpty())) {
			System.out.println("\nOpCode : " + partitionUnit.getOpCode().getOpCodeId());
		} else {
			System.out.println("No OpCode defined in PartitionUnit"); 
		}
		
		return this.processRun1Pipeline(partitionUnit.getShiftAssignmentList(), partitionUnit.getEmployeeList());		
	}
	
	
	/**
	 * 
	 * @param shiftAssignments
	 * @param employees
	 * @return
	 */
	private SolutionResult processRun1Pipeline(List<ShiftAssignment> shiftAssignments, List<Employee> employees)  {
		
		if (shiftAssignments.isEmpty()) {
			System.out.println("No ShiftAssignments to process.");
			return null; // use null for now
		}
				
		StringBuffer opCodeBuffer = new StringBuffer();
		for (ShiftAssignment sa : shiftAssignments) {
			System.out.println("Preparing to perform run Scheduling pipeline for OpCode : " + sa.getOpCode().getOpCodeId()); 
			opCodeBuffer.append(sa.getOpCode().getOpCodeId() + " | ");
		}
		
		if (wfProps.isDoPattern()) {
			// custom phase
			System.out.println(">> Performing Pattern Employee Hard Constraints check...");
		} else {
			System.out.println("* Ignoring Pattern Employee phase...");
		}
		
		if (wfProps.isDoRun1()) {
			System.out.println(">> Performing Optaplanner Run 1...");			
		} else {
			System.out.println("* Ignoring Performing Optaplanner Run 1...");	
		}
		
		SolutionResult sr = new SolutionResult();
		sr.setResultDesc(" -- Opcode : " + opCodeBuffer + " -- ShiftAssignments : " + shiftAssignments.size());			
		return sr;		
	}
	
	
	/**
	 * 
	 * @param fullSolutionResult
	 */
	private void processRun2Pipeline(List<SolutionResult> fullSolutionResults) {	
		// grab opCode from first shift assignment
		System.out.println("\n\n >>>> Processing run 2 pipeline : ");
		for (SolutionResult sr : fullSolutionResults) {
			System.out.println(" SolutionResult : " + sr.getResultDesc());
		}
				
	}
	

}
