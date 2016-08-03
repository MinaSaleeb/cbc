package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the prayer_times database table.
 * 
 */
@Entity
@Table(name="prayer_times")
public class PrayerTime implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="praying_date")
	private Date prayingDate;

	@Column(name="praying_time_name")
	private String prayingTimeName;

	public PrayerTime() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getPrayingDate() {
		return this.prayingDate;
	}

	public void setPrayingDate(Date prayingDate) {
		this.prayingDate = prayingDate;
	}

	public String getPrayingTimeName() {
		return this.prayingTimeName;
	}

	public void setPrayingTimeName(String prayingTimeName) {
		this.prayingTimeName = prayingTimeName;
	}

}