package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the site_pages database table.
 * 
 */
@Entity
@Table(name="site_pages")
public class ProgramPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="page_code")
	private String pageCode;

	@Column(name="page_name")
	private String pageName;
/*
	//bi-directional many-to-many association to Program
	@ManyToMany(mappedBy="programPages")
	private List<Program> programs;
*/
	//bi-directional many-to-one association to ProgramPagesAdDiv
	@OneToMany(mappedBy="programPage")
	private List<ProgramPagesAdDiv> programPagesAdDivs;

	public ProgramPage() {
	}

	public String getPageCode() {
		return this.pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
/*
	public List<Program> getProgramBean() {
		return this.programs;
	}

	public void setProgramBean(List<Program> programs) {
		this.programs = programs;
	}
*/
	public List<ProgramPagesAdDiv> getProgramPagesAdDivs() {
		return this.programPagesAdDivs;
	}

	public void setProgramPagesAdDivs(List<ProgramPagesAdDiv> programPagesAdDivs) {
		this.programPagesAdDivs = programPagesAdDivs;
	}

	public ProgramPagesAdDiv addProgramPagesAdDiv(ProgramPagesAdDiv programPagesAdDiv) {
		getProgramPagesAdDivs().add(programPagesAdDiv);
		programPagesAdDiv.setProgramPage(this);

		return programPagesAdDiv;
	}

	public ProgramPagesAdDiv removeProgramPagesAdDiv(ProgramPagesAdDiv programPagesAdDiv) {
		getProgramPagesAdDivs().remove(programPagesAdDiv);
		programPagesAdDiv.setProgramPage(null);

		return programPagesAdDiv;
	}

}