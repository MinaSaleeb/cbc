/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina
 *
 */
public class SelectedItem 
{
	private String image;
	
	private String title;
	
	private String ItemId;
	
	private String ItemType;
	
	private short status;
	
	private int order;

	/**
	 * 
	 */
	public SelectedItem(com.cbc.model.SelectedItemForYou mod) {
		super();
		ModelToDomainMapper.mapSelectedItem(mod, this);
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
	 * @return the itemId
	 */
	public String getItemId() {
		return ItemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		ItemId = itemId;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return ItemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		ItemType = itemType;
	}

	/**
	 * @return the status
	 */
	public short getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(short status) {
		this.status = status;
	}

	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	
	
	
}
