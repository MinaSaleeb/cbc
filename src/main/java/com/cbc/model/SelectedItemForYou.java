/**
 * 
 */
package com.cbc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mina Saleeb
 *
 */
@Entity
@Table(name="selected_items")
public class SelectedItemForYou implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="item_id")
	private String ItemId;
	
	@Column(name="item_type")
	private String itemType;
	
	@Column(nullable = false, columnDefinition = "SMALLINT(6) default 0")
	private short status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(nullable = false, columnDefinition = "SMALLINT(6) default 0")
	private short order;

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
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
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
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the order
	 */
	public short getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(short order) {
		this.order = order;
	}
}
