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
 * @author Mina Saleeb
 *
 */
@Entity
@Table(name="news_media_items")
public class NewsMedia implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="new_id")
	private CbcNew cbcNew;
	
	@Column(name="image_path")
	private String imagePath;

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
	 * @return the cbcNew
	 */
	public CbcNew getCbcNew() {
		return cbcNew;
	}

	/**
	 * @param cbcNew the cbcNew to set
	 */
	public void setCbcNew(CbcNew cbcNew) {
		this.cbcNew = cbcNew;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}	
