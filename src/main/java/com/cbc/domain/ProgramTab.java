/**
 * 
 */
package com.cbc.domain;

import java.util.List;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class ProgramTab 
{
	private int id;
	
	private String name;
	
	private String contentType;
	
	private List<ProgramTabContent> contents;
	
	private List<ProgramTab> childTabs;
	
	public ProgramTab(com.cbc.model.ProgramTab pt) 
	{
		super();
		ModelToDomainMapper.mapProgramTab(pt, this);
	}

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
	 * @return the contents
	 */
	public List<ProgramTabContent> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<ProgramTabContent> contents) {
		this.contents = contents;
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
