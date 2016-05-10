/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.model.Channel;
import com.cbc.model.Presenter;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.PresenterRepository;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class PresentersService 
{
	private static final Logger LOGGER = Logger.getLogger(PresentersService.class);
	
	@Autowired
	private PresenterRepository presenterRepo;
	
	@Autowired
	private ChannelRepository channelRepo;
	
	/**
	 * 
	 * @param presenterId
	 * @return
	 */
	public Presenter getPresenterById(int presenterId)
	{
		return presenterRepo.findOne(presenterId);
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<Presenter> getPresentersByChannel(int channelId)
	{
		List<Presenter> presentersList = new ArrayList<Presenter>();
		
		Channel channel = channelRepo.findOne(channelId);
		if(channel != null)
		{
			//presentersList = programRepository.findByChannelBean(channel);
		}
		else
		{
			LOGGER.error("channelId {"+channelId+"} is not found in DB");
		}
		
		return presentersList;
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<String> getPresentersNamesByChannelId(int channelId)
	{
		List<String> presentersNamesList = new ArrayList<String>();
		
		List<Presenter> presenters = getPresentersByChannel(channelId);
		if(presenters != null && !presenters.isEmpty())
		{
			for(Presenter prsntr : presenters)
			{
				presentersNamesList.add(prsntr.getName());
			}
		}
		
		return presentersNamesList;
	}
	
}
