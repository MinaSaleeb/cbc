/**
 * 
 */
package com.cbc.domain;

/**
 * @author Mina Saleeb
 *
 */
public class HubTimeLine 
{
	private com.cbc.domain.Channel channel;
	
	private String programName;
	
	private int programId;

	
	
	/**
	 * @param channel
	 * @param programName
	 * @param programId
	 */
	public HubTimeLine(Channel channel, String programName, int programId) {
		super();
		this.channel = channel;
		this.programName = programName;
		this.programId = programId;
	}

	/**
	 * @return the channel
	 */
	public com.cbc.domain.Channel getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(com.cbc.domain.Channel channel) {
		this.channel = channel;
	}

	/**
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}

	/**
	 * @param programName the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 * @return the programId
	 */
	public int getProgramId() {
		return programId;
	}

	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	
	
}
