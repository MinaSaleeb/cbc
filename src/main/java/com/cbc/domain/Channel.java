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
	private String channelBgImage;

	private String channelImage;

	private String channelName;

	private String liveStreamingUrl;

	public Channel(com.cbc.model.Channel modChnl)
	{
		super();
		ModelToDomainMapper.mapChannel(modChnl, this);
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
}
