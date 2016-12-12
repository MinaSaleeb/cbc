/**
 * 
 */
package com.cbc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the program_tabs database table.
 * 
 * @author Mina Saleeb
 *
 */
@Entity
@Table(name="program_tabs")
public class ProgramTab implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(name="content_type")
	private String contentType;
	
	@ManyToOne
	@JoinColumn(name="program_id")
	private Program programBean;
	
	@OneToMany(mappedBy="programTabBean")
	private List<ProgramTabContent> programTabContents;
	
	@ManyToOne
	@JoinColumn(name="parent_tab")
	private ProgramTab parentTab;

	@OneToMany(mappedBy="parentTab")
	private List<ProgramTab> childTabs;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the programBean
	 */
	public Program getProgramBean() {
		return programBean;
	}

	/**
	 * @param programBean the programBean to set
	 */
	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

	/**
	 * @return the programTabContents
	 */
	public List<ProgramTabContent> getProgramTabContents() {
		return programTabContents;
	}

	/**
	 * @param programTabContents the programTabContents to set
	 */
	public void setProgramTabContents(List<ProgramTabContent> programTabContents) {
		this.programTabContents = programTabContents;
	}

	/**
	 * @return the parentTab
	 */
	public ProgramTab getParentTab() {
		return parentTab;
	}

	/**
	 * @param parentTab the parentTab to set
	 */
	public void setParentTab(ProgramTab parentTab) {
		this.parentTab = parentTab;
	}

	/**
	 * @return the childTabs
	 */
	public List<ProgramTab> getChildTabs() {
		return childTabs;
	}

	/**
	 * @param childTabs the childTabs to set
	 */
	public void setChildTabs(List<ProgramTab> childTabs) {
		this.childTabs = childTabs;
	}
	
	

}
