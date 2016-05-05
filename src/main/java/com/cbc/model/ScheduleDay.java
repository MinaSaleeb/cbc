package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the schedule_days database table.
 * 
 */
@Entity
@Table(name="schedule_days")
public class ScheduleDay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="actual_date")
	private Date actualDate;

	//bi-directional many-to-one association to TimeLine
	@OneToMany(mappedBy="scheduleDay")
	private List<TimeLine> timeLines;

	public ScheduleDay() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getActualDate() {
		return this.actualDate;
	}

	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}

	public List<TimeLine> getTimeLines() {
		return this.timeLines;
	}

	public void setTimeLines(List<TimeLine> timeLines) {
		this.timeLines = timeLines;
	}

	public TimeLine addTimeLine(TimeLine timeLine) {
		getTimeLines().add(timeLine);
		timeLine.setScheduleDay(this);

		return timeLine;
	}

	public TimeLine removeTimeLine(TimeLine timeLine) {
		getTimeLines().remove(timeLine);
		timeLine.setScheduleDay(null);

		return timeLine;
	}

}