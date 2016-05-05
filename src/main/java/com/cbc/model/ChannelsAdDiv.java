package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the channels_ad_divs database table.
 * 
 */
@Entity
@Table(name="channels_ad_divs")
public class ChannelsAdDiv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChannelsAdDivPK id;

	@Column(name="ad_script")
	private String adScript;

	//bi-directional many-to-one association to Channel
	@ManyToOne
	@JoinColumn(name="channel", insertable=false, updatable=false)
	private Channel channelBean;

	//bi-directional many-to-one association to AdDiv
	@ManyToOne
	@JoinColumn(name="div_code", insertable=false, updatable=false)
	private AdDiv adDiv;

	public ChannelsAdDiv() {
	}

	public ChannelsAdDivPK getId() {
		return this.id;
	}

	public void setId(ChannelsAdDivPK id) {
		this.id = id;
	}

	public String getAdScript() {
		return this.adScript;
	}

	public void setAdScript(String adScript) {
		this.adScript = adScript;
	}

	public Channel getChannelBean() {
		return this.channelBean;
	}

	public void setChannelBean(Channel channelBean) {
		this.channelBean = channelBean;
	}

	public AdDiv getAdDiv() {
		return this.adDiv;
	}

	public void setAdDiv(AdDiv adDiv) {
		this.adDiv = adDiv;
	}

}