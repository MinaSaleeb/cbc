/**
 * 
 */
package com.cbc.domain;

/**
 * @author Mina Saleeb
 *
 */
public class CarouselItem 
{
	private String image;
	private int programId;
	
	/**
	 * @param image
	 * @param programId
	 */
	public CarouselItem(String image, int programId) {
		super();
		this.image = image;
		this.programId = programId;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
	
	
}
