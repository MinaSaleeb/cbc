/**
 * 
 */
package com.cbc.util;

/**
 * @author Mina Saleeb
 *
 */
public class ModelToDomainMapper 
{
	public static void mapChannel(com.cbc.model.Channel modChnl , com.cbc.domain.Channel domChnl)
	{
		domChnl.setChannelName(modChnl.getChannelName());
		domChnl.setChannelImage(modChnl.getChannelImage());
		domChnl.setChannelBgImage(modChnl.getChannelBgImage());
		domChnl.setLiveStreamingUrl(modChnl.getLiveStreamingUrl());
	}
}
