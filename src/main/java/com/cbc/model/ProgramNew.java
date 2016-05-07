package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the program_news database table.
 * 
 */
@Entity
@Table(name="program_news")
public class ProgramNew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="program")
	private Program programBean;

	//bi-directional many-to-one association to CbcNew
	@ManyToOne
	@JoinColumn(name="related_new_obj")
	private CbcNew cbcNew;

	public ProgramNew() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Program getProgramBean() {
		return this.programBean;
	}

	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

	public CbcNew getCbcNew() {
		return this.cbcNew;
	}

	public void setCbcNew(CbcNew cbcNew) {
		this.cbcNew = cbcNew;
	}

}