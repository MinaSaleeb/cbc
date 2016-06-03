/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.Constants.MostViewedType;

/**
 * @author Mina Saleeb
 *
 */
public class MediaContentTuple 
{
	private MostViewedType mediaType;
	private String url;
	private String programName;
	private String programImage;
	private int programId;
	private String description;
	/**
	 * @return the mediaType
	 */
	public MostViewedType getMediaType() {
		return mediaType;
	}
	/**
	 * @param mediaType the mediaType to set
	 */
	public void setMediaType(MostViewedType mediaType) {
		this.mediaType = mediaType;
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
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}
	/**
	 * @param programName the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	/**
	 * @return the programImage
	 */
	public String getProgramImage() {
		return programImage;
	}
	/**
	 * @param programImage the programImage to set
	 */
	public void setProgramImage(String programImage) {
		this.programImage = programImage;
	}
	/**
	 * @return the programId
	 */
	public int getProgramId() {
		return programId;
	}
	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(int programId) {
		this.programId = programId;
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
	
	
}
