package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the program_pages_ad_divs database table.
 * 
 */
@Embeddable
public class ProgramPagesAdDivPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="page_code", insertable=false, updatable=false)
	private String pageCode;

	@Column(name="div_code", insertable=false, updatable=false)
	private String divCode;

	public ProgramPagesAdDivPK() {
	}
	public String getPageCode() {
		return this.pageCode;
	}
	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
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
		if (!(other instanceof ProgramPagesAdDivPK)) {
			return false;
		}
		ProgramPagesAdDivPK castOther = (ProgramPagesAdDivPK)other;
		return 
			this.pageCode.equals(castOther.pageCode)
			&& this.divCode.equals(castOther.divCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pageCode.hashCode();
		hash = hash * prime + this.divCode.hashCode();
		
		return hash;
	}
}