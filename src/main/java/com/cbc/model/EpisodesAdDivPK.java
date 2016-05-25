package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the episodes_ad_divs database table.
 * 
 */
@Embeddable
public class EpisodesAdDivPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long episode;

	@Column(name="div_code", insertable=false, updatable=false)
	private String divCode;

	public EpisodesAdDivPK() {
	}
	public long getEpisode() {
		return this.episode;
	}
	public void setEpisode(long episode) {
		this.episode = episode;
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
		if (!(other instanceof EpisodesAdDivPK)) {
			return false;
		}
		EpisodesAdDivPK castOther = (EpisodesAdDivPK)other;
		return 
			this.episode == castOther.episode
			&& this.divCode.equals(castOther.divCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (""+this.episode).hashCode();
		hash = hash * prime + this.divCode.hashCode();
		
		return hash;
	}
}