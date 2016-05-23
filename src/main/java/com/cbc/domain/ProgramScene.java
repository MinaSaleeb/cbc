/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class ProgramScene 
{
	private int id;

	private String description;

	private String photoPath;

	private String title;

	private String vedioUrl;
	
	private boolean hubSelected;
	
	

	/**
	 * 
	 */
	public ProgramScene(com.cbc.model.ProgramScene ps) 
	{
		super();
		ModelToDomainMapper.mapProgramScene(ps, this);
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
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
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
	 * @return the vedioUrl
	 */
	public String getVedioUrl() {
		return vedioUrl;
	}

	/**
	 * @param vedioUrl the vedioUrl to set
	 */
	public void setVedioUrl(String vedioUrl) {
		this.vedioUrl = vedioUrl;
	}

	/**
	 * @return the hubSelected
	 */
	public boolean isHubSelected() {
		return hubSelected;
	}

	/**
	 * @param hubSelected the hubSelected to set
	 */
	public void setHubSelected(boolean hubSelected) {
		this.hubSelected = hubSelected;
	}
	
}
