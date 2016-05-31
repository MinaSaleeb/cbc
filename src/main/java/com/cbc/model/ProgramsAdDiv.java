package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the programs_ad_divs database table.
 * 
 */
@Entity
@Table(name="programs_ad_divs")
public class ProgramsAdDiv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="ad_script")
	private String adScript;

	//bi-directional many-to-one association to AdDiv
	@ManyToOne
	@JoinColumn(name="div_code", insertable=false, updatable=false)
	private AdDiv adDiv;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="program", insertable=false, updatable=false)
	private Program programBean;

	public ProgramsAdDiv() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdScript() {
		return this.adScript;
	}

	public void setAdScript(String adScript) {
		this.adScript = adScript;
	}

	public AdDiv getAdDiv() {
		return this.adDiv;
	}

	public void setAdDiv(AdDiv adDiv) {
		this.adDiv = adDiv;
	}

	public Program getProgramBean() {
		return this.programBean;
	}

	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

}