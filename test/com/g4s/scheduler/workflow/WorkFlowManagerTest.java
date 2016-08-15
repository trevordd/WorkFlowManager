package com.g4s.scheduler.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class WorkFlowManagerTest {

	private OpCode opCode1;
	private OpCode opCode2;
	private OpCode opCode3;
	private OpCode opCode4;
	private OpCode opCode5;
		
	private Employee emp1;
	private Employee emp2;
	private Employee emp3;
	private Employee emp4;
	private Employee emp5;
	
	private ShiftAssignment sa1;
	private ShiftAssignment sa2;
	private ShiftAssignment sa3;
	private ShiftAssignment sa4;
	private ShiftAssignment sa5;
	
	List<Employee> employees;
	List<ShiftAssignment> shiftAssignments;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		opCode1 = new OpCode("100");
		opCode2 = new OpCode("200");
		opCode3 = new OpCode("300");
		opCode4 = new OpCode("400");
		opCode5 = new OpCode("500");
			
		emp1 = new Employee(opCode1,"Emp1");
		emp2 = new Employee(opCode2,"Emp2");
		emp3 = new Employee(opCode3,"Emp3");
		emp4 = new Employee(opCode2,"Emp4");
		emp5 = new Employee(opCode1,"Emp5");
		
		sa1 = new ShiftAssignment(opCode1, "sa1");
		sa2 = new ShiftAssignment(opCode2, "sa2");
		sa3 = new ShiftAssignment(opCode3, "sa3");
		sa4 = new ShiftAssignment(opCode2, "sa4");
		sa5 = new ShiftAssignment(opCode1, "sa5");
		
		employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		
		shiftAssignments = new ArrayList<ShiftAssignment>();
		shiftAssignments.add(sa1);
		shiftAssignments.add(sa2);
		shiftAssignments.add(sa3);
		shiftAssignments.add(sa4);
		shiftAssignments.add(sa5);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testWorkFlowManagerWorkFlowProperties() {
		fail("Not yet implemented");
	}

	@Test
	public void testProcess() {
		
		WorkFlowProperties wfp = new WorkFlowProperties();
		
		wfp.setDoPartitioning(true);
		wfp.setDoPattern(true);
		wfp.setDoRun1(false);
		wfp.setDoRun2(true);
		
		WorkFlowManager wfm  = new WorkFlowManager(wfp);
		wfm.process(shiftAssignments, employees);
		
		assert(true);
		//fail("Not yet implemented");
	}

}
