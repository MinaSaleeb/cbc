package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ad_divs database table.
 * 
 */
@Entity
@Table(name="ad_divs")
@NamedQuery(name="AdDiv.findAll", query="SELECT a FROM AdDiv a")
public class AdDiv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="div_code")
	private String divCode;

	private String description;

	

	public AdDiv() {
	}

	public String getDivCode() {
		return this.divCode;
	}

	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}