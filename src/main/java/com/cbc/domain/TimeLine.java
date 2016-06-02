/**
 * 
 */
package com.cbc.domain;

import com.cbc.domain.Program;
import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class TimeLine 
{
	private long id;

	private float duration;

	private boolean repeated;
	
	private String startTime;

	private Program program;
	
	private boolean playingNow = false;
	
	

	/**
	 * 
	 */
	public TimeLine(com.cbc.model.TimeLine tl)
	{
		super();
		ModelToDomainMapper.mapTimeLine(tl, this);
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the duration
	 */
	public float getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(float duration) {
		this.duration = duration;
	}

	/**
	 * @return the repeated
	 */
	public boolean isRepeated() {
		return repeated;
	}

	/**
	 * @param repeated the repeated to set
	 */
	public void setRepeated(boolean repeated) {
		this.repeated = repeated;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the program
	 */
	public Program getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(Program program) {
		this.program = program;
	}

	/**
	 * @return the playingNow
	 */
	public boolean isPlayingNow() {
		return playingNow;
	}

	/**
	 * @param playingNow the playingNow to set
	 */
	public void setPlayingNow(boolean playingNow) {
		this.playingNow = playingNow;
	}
	
	
}
