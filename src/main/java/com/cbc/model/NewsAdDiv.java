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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mina Saleeb
 *
 *The persistent class for the news_ad_divs database table.
 */
@Entity
@Table(name="news_ad_divs")
public class NewsAdDiv implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Lob
	@Column(name="ad_script")
	private String adScript;
	
	@ManyToOne
	@JoinColumn(name="new_id", insertable=false, updatable=false)
	private CbcNew cbcNew;
	
	@ManyToOne
	@JoinColumn(name="div_code", insertable=false, updatable=false)
	private AdDiv adDiv;

	public NewsAdDiv() {
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
	 * @return the adScript
	 */
	public String getAdScript() {
		return adScript;
	}

	/**
	 * @param adScript the adScript to set
	 */
	public void setAdScript(String adScript) {
		this.adScript = adScript;
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
	 * @return the adDiv
	 */
	public AdDiv getAdDiv() {
		return adDiv;
	}

	/**
	 * @param adDiv the adDiv to set
	 */
	public void setAdDiv(AdDiv adDiv) {
		this.adDiv = adDiv;
	}

}
