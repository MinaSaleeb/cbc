package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the time_lines database table.
 * 
 */
@Entity
@Table(name="time_lines")
public class TimeLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private int duration;

	@Column(name="is_repeated")
	private byte isRepeated;

	@Column(name="start_time")
	private String startTime;

	//bi-directional many-to-one association to Channel
	@ManyToOne
	@JoinColumn(name="channel")
	private Channel channelBean;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="program")
	private Program programBean;

	//bi-directional many-to-one association to ScheduleDay
	@ManyToOne
	@JoinColumn(name="day")
	private ScheduleDay scheduleDay;

	public TimeLine() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public byte getIsRepeated() {
		return this.isRepeated;
	}

	public void setIsRepeated(byte isRepeated) {
		this.isRepeated = isRepeated;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Channel getChannelBean() {
		return this.channelBean;
	}

	public void setChannelBean(Channel channelBean) {
		this.channelBean = channelBean;
	}

	public Program getProgramBean() {
		return this.programBean;
	}

	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

	public ScheduleDay getScheduleDay() {
		return this.scheduleDay;
	}

	public void setScheduleDay(ScheduleDay scheduleDay) {
		this.scheduleDay = scheduleDay;
	}

}