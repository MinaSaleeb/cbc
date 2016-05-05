package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the program_pages database table.
 * 
 */
@Entity
@Table(name="program_pages")
@NamedQuery(name="ProgramPage.findAll", query="SELECT p FROM ProgramPage p")
public class ProgramPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="page_code")
	private String pageCode;

	@Column(name="page_name")
	private String pageName;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="program")
	private Program programBean;

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

	public Program getProgramBean() {
		return this.programBean;
	}

	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

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