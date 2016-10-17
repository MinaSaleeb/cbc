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
	
	private List<ProgramTabContent> contents;
	
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
}
