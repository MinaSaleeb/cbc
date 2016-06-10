package com.cbc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cbc.util.TimeUtils;


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

	private float duration;

	@Column(name="is_repeated")
	private byte isRepeated;

	@Column(name="start_time")
	private String startTime;

	//bi-directional many-to-one association to Channel
	@ManyToOne
	@JoinColumn(name="channel")
	private Channel channelBean;

	//bi-directional many-to-one association to Program
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="program")
	private Program programBean;

	//bi-directional many-to-one association to ScheduleDay
	@ManyToOne
	@JoinColumn(name="day")
	private ScheduleDay scheduleDay;
	
	@Transient
	private boolean playingNow = false;
	
	@Transient
	private Date startDateTime;
	
	@Transient
	private Date endDateTime;

	
	public TimeLine() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getDuration() {
		return this.duration;
	}

	public void setDuration(float duration) {
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
	
	/**
	 * @return the playingNow
	 */
	@Transient
	public boolean isPlayingNow() 
	{
		float currentHour = TimeUtils.getCurrentHourAs_24();
		float timeLineStartHour = TimeUtils.convert_hhaa_to_24(this.getStartTime());
		float timeLineEndHour = timeLineStartHour + this.getDuration();
		if(currentHour >= timeLineStartHour && currentHour < timeLineEndHour) 
		{
			return true;
		}
		
		return false;
	}

	/**
	 * @return the startDateTime
	 */
	@Transient
	public Date getStartDateTime() 
	{
		if(this.startDateTime == null)
		{
			this.startDateTime = TimeUtils.getDateTime(this.scheduleDay.getActualDate() , this.startTime);
		}
		return this.startDateTime;
	}

	/**
	 * @return the endDateTime
	 */
	@Transient
	public Date getEndDateTime() 
	{
		if(this.endDateTime == null)
		{
			this.endDateTime = TimeUtils.addMinuts(getStartDateTime(), this.duration);
		}
		
		return this.endDateTime;
	}

}