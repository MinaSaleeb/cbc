/**
 * 
 */
package com.cbc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the program_tab_contents database table.
 * 
 * @author Mina Saleeb
 *
 */
@Entity
@Table(name="program_tab_contents")
public class ProgramTabContent implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String description;
	
	private String title;
	
	@Column(name="content_url")
	private String contentUrl;
	
	@Column(name="content_type")
	private String contentType;
	
	@ManyToOne
	@JoinColumn(name="program_tab_id")
	private ProgramTab programTabBean;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the contentUrl
	 */
	public String getContentUrl() {
		return contentUrl;
	}

	/**
	 * @param contentUrl the contentUrl to set
	 */
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
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
	 * @return the programTabBean
	 */
	public ProgramTab getProgramTabBean() {
		return programTabBean;
	}

	/**
	 * @param programTabBean the programTabBean to set
	 */
	public void setProgramTabBean(ProgramTab programTabBean) {
		this.programTabBean = programTabBean;
	}
	
}
