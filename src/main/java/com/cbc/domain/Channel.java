/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class Channel
{
	private int id;
	
	private String channelBgImage;

	private String channelImage;

	private String channelName;

	private String liveStreamingUrl;
	
	private String hubCarouelImage;
	
	private String promoUrl;

	public Channel(com.cbc.model.Channel modChnl)
	{
		super();
		ModelToDomainMapper.mapChannel(modChnl, this);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the channelBgImage
	 */
	public String getChannelBgImage() {
		return channelBgImage;
	}

	/**
	 * @param channelBgImage the channelBgImage to set
	 */
	public void setChannelBgImage(String channelBgImage) {
		this.channelBgImage = channelBgImage;
	}

	/**
	 * @return the channelImage
	 */
	public String getChannelImage() {
		return channelImage;
	}

	/**
	 * @param channelImage the channelImage to set
	 */
	public void setChannelImage(String channelImage) {
		this.channelImage = channelImage;
	}

	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * @param channelName the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	/**
	 * @return the liveStreamingUrl
	 */
	public String getLiveStreamingUrl() {
		return liveStreamingUrl;
	}

	/**
	 * @param liveStreamingUrl the liveStreamingUrl to set
	 */
	public void setLiveStreamingUrl(String liveStreamingUrl) {
		this.liveStreamingUrl = liveStreamingUrl;
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
}
