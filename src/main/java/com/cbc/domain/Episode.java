/**
 * 
 */
package com.cbc.domain;

import java.math.BigInteger;
import java.util.Date;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class Episode 
{
	private long id;

	private BigInteger numberOfViews;

	private String title;

	private String url;
	
	private Date displayingDate;

	private boolean hubSelected;
	
	private String photoPath;
	
	
	
	

	/**
	 * 
	 */
	public Episode(com.cbc.model.Episode e) 
	{
		super();
		ModelToDomainMapper.mapEpisode(e, this);
	}

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
	 * @return the numberOfViews
	 */
	public BigInteger getNumberOfViews() {
		return numberOfViews;
	}

	/**
	 * @param numberOfViews the numberOfViews to set
	 */
	public void setNumberOfViews(BigInteger numberOfViews) {
		this.numberOfViews = numberOfViews;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the displayingDate
	 */
	public Date getDisplayingDate() {
		return displayingDate;
	}

	/**
	 * @param displayingDate the displayingDate to set
	 */
	public void setDisplayingDate(Date displayingDate) {
		this.displayingDate = displayingDate;
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
	
	
	
}
