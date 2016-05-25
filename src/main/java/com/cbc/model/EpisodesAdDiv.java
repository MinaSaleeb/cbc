package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the episodes_ad_divs database table.
 * 
 */
@Entity
@Table(name="episodes_ad_divs")
public class EpisodesAdDiv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EpisodesAdDivPK id;

	@Lob
	@Column(name="ad_script")
	private String adScript;
	
	@ManyToOne
	@JoinColumn(name="episode", insertable=false, updatable=false)
	private Episode episodeBean;
	
	@ManyToOne
	@JoinColumn(name="div_code", insertable=false, updatable=false)
	private AdDiv adDiv;

	public EpisodesAdDiv() {
	}

	public EpisodesAdDivPK getId() {
		return this.id;
	}

	public void setId(EpisodesAdDivPK id) {
		this.id = id;
	}

	public String getAdScript() {
		return this.adScript;
	}

	public void setAdScript(String adScript) {
		this.adScript = adScript;
	}

	/**
	 * @return the episodeBean
	 */
	public Episode getEpisodeBean() {
		return episodeBean;
	}

	/**
	 * @param episodeBean the episodeBean to set
	 */
	public void setEpisodeBean(Episode episodeBean) {
		this.episodeBean = episodeBean;
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