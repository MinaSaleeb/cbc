/**
 * 
 */
package com.cbc.domain.recipe;

/**
 * @author Mina
 *
 */
public class Step
{
	private String stepContent;
	private double startTime;
	private double endTime;
	/**
	 * @param stepContent
	 * @param startTime
	 * @param endTime
	 */
	public Step(String stepContent, double startTime, double endTime) {
		super();
		this.stepContent = stepContent;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	/**
	 * @return the stepContent
	 */
	public String getStepContent() {
		return stepContent;
	}
	/**
	 * @param stepContent the stepContent to set
	 */
	public void setStepContent(String stepContent) {
		this.stepContent = stepContent;
	}
	/**
	 * @return the startTime
	 */
	public double getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public double getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
}
