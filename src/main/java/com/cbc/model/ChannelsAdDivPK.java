package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the channels_ad_divs database table.
 * 
 */
@Embeddable
public class ChannelsAdDivPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int channel;

	@Column(name="div_code", insertable=false, updatable=false)
	private String divCode;

	public ChannelsAdDivPK() {
	}
	public int getChannel() {
		return this.channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public String getDivCode() {
		return this.divCode;
	}
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ChannelsAdDivPK)) {
			return false;
		}
		ChannelsAdDivPK castOther = (ChannelsAdDivPK)other;
		return 
			(this.channel == castOther.channel)
			&& this.divCode.equals(castOther.divCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.channel;
		hash = hash * prime + this.divCode.hashCode();
		
		return hash;
	}
}