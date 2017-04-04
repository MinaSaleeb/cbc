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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="ad_script")
	private String adScript;
	
	private String script;

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

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdScript() {
		return this.adScript;
	}

	public void setAdScript(String adScript) {
		this.adScript = adScript;
	}

	/**
	 * @return the script
	 */
	public String getScript() {
		return script;
	}

	/**
	 * @param script the script to set
	 */
	public void setScript(String script) {
		this.script = script;
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