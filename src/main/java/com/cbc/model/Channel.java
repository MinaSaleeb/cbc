package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the channels database table.
 * 
 */
@Entity
@Table(name="channels")
public class Channel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="channel_bg_image")
	private String channelBgImage;

	@Column(name="channel_image")
	private String channelImage;
	
	@Column(name="hub_carouel_image")
	private String hubCarouelImage;

	@Column(name="channel_name")
	private String channelName;

	@Column(name="live_streaming_url")
	private String liveStreamingUrl;
	
	@Column(name="promo_url")
	private String promoUrl;

	//bi-directional many-to-many association to Program
	@ManyToMany(mappedBy="channels")
	private List<Program> programs;

	//bi-directional many-to-one association to ChannelsAdDiv
	@OneToMany(mappedBy="channelBean")
	private List<ChannelsAdDiv> channelsAdDivs;

	public Channel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannelBgImage() {
		return this.channelBgImage;
	}

	public void setChannelBgImage(String channelBgImage) {
		this.channelBgImage = channelBgImage;
	}

	public String getChannelImage() {
		return this.channelImage;
	}

	public void setChannelImage(String channelImage) {
		this.channelImage = channelImage;
	}

	/**
	 * @return the hubCarouelImage
	 */
	public String getHubCarouelImage() {
		return hubCarouelImage;
	}

	/**
	 * @param hubCarouelImage the hubCarouelImage to set
	 */
	public void setHubCarouelImage(String hubCarouelImage) {
		this.hubCarouelImage = hubCarouelImage;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getLiveStreamingUrl() {
		return this.liveStreamingUrl;
	}

	public void setLiveStreamingUrl(String liveStreamingUrl) {
		this.liveStreamingUrl = liveStreamingUrl;
	}

	/**
	 * @return the promoUrl
	 */
	public String getPromoUrl() {
		return promoUrl;
	}

	/**
	 * @param promoUrl the promoUrl to set
	 */
	public void setPromoUrl(String promoUrl) {
		this.promoUrl = promoUrl;
	}

	public List<Program> getPrograms() {
		return this.programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}


	public List<ChannelsAdDiv> getChannelsAdDivs() {
		return this.channelsAdDivs;
	}

	public void setChannelsAdDivs(List<ChannelsAdDiv> channelsAdDivs) {
		this.channelsAdDivs = channelsAdDivs;
	}

	public ChannelsAdDiv addChannelsAdDiv(ChannelsAdDiv channelsAdDiv) {
		getChannelsAdDivs().add(channelsAdDiv);
		channelsAdDiv.setChannelBean(this);

		return channelsAdDiv;
	}

	public ChannelsAdDiv removeChannelsAdDiv(ChannelsAdDiv channelsAdDiv) {
		getChannelsAdDivs().remove(channelsAdDiv);
		channelsAdDiv.setChannelBean(null);

		return channelsAdDiv;
	}

}