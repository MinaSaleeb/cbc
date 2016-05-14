/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return presenterRepo.findByChannelId(channelId);
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
	
	/**
	 * 
	 * @return
	 */
	public List<Presenter> listAllPresenters()
	{
		return (List<Presenter>) presenterRepo.findAll();
	}
	
}
