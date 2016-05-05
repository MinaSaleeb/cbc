package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the program_pages_ad_divs database table.
 * 
 */
@Entity
@Table(name="program_pages_ad_divs")
@NamedQuery(name="ProgramPagesAdDiv.findAll", query="SELECT p FROM ProgramPagesAdDiv p")
public class ProgramPagesAdDiv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProgramPagesAdDivPK id;

	@Column(name="ad_script")
	private String adScript;

	//bi-directional many-to-one association to AdDiv
	@ManyToOne
	@JoinColumn(name="div_code", insertable=false, updatable=false)
	private AdDiv adDiv;

	//bi-directional many-to-one association to ProgramPage
	@ManyToOne
	@JoinColumn(name="page_code", insertable=false, updatable=false)
	private ProgramPage programPage;

	public ProgramPagesAdDiv() {
	}

	public ProgramPagesAdDivPK getId() {
		return this.id;
	}

	public void setId(ProgramPagesAdDivPK id) {
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

	public ProgramPage getProgramPage() {
		return this.programPage;
	}

	public void setProgramPage(ProgramPage programPage) {
		this.programPage = programPage;
	}

}