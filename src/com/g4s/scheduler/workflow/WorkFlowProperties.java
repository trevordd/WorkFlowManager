package com.g4s.scheduler.workflow;

public class WorkFlowProperties {

	
	private boolean doPartitioning;
	private boolean doPattern;
	private boolean doRun1;
	private boolean doRun2;
	
	public WorkFlowProperties() {
		
	}

	public boolean isDoPartitioning() {
		return doPartitioning;
	}

	public void setDoPartitioning(boolean doPartitioning) {
		this.doPartitioning = doPartitioning;
	}

	public boolean isDoPattern() {
		return doPattern;
	}

	public void setDoPattern(boolean doPattern) {
		this.doPattern = doPattern;
	}

	public boolean isDoRun1() {
		return doRun1;
	}

	public void setDoRun1(boolean doRun1) {
		this.doRun1 = doRun1;
	}

	public boolean isDoRun2() {
		return doRun2;
	}

	public void setDoRun2(boolean doRun2) {
		this.doRun2 = doRun2;
	}
	
	
	
}
