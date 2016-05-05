package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the programs_ad_divs database table.
 * 
 */
@Embeddable
public class ProgramsAdDivPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int program;

	@Column(name="div_code", insertable=false, updatable=false)
	private String divCode;

	public ProgramsAdDivPK() {
	}
	public int getProgram() {
		return this.program;
	}
	public void setProgram(int program) {
		this.program = program;
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
		if (!(other instanceof ProgramsAdDivPK)) {
			return false;
		}
		ProgramsAdDivPK castOther = (ProgramsAdDivPK)other;
		return 
			(this.program == castOther.program)
			&& this.divCode.equals(castOther.divCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.program;
		hash = hash * prime + this.divCode.hashCode();
		
		return hash;
	}
}