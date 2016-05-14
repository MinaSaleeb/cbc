/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.model.CbcNew;
import com.cbc.model.Channel;
import com.cbc.model.Program;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.ProgramNewsRepository;
import com.cbc.repository.ProgramRepository;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class ProgramsService 
{

	private static final Logger LOGGER = Logger.getLogger(ProgramsService.class);
	
	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private ChannelRepository channelRepository;
	
	@Autowired
	private ProgramNewsRepository programNewsRepo;
	
	
	/**
	 * 
	 * @param channelId
	 * @return
	 * @throws Exception
	 */
	public List<Program> retrieveProgramsByChannel(int channelId) throws Exception
	{
		List<Program> programsList = new ArrayList<Program>();
		Channel channel = channelRepository.findOne(channelId);
		if(channel != null)
		{
			programsList = programRepository.findByChannelBean(channel);
		}
		else
		{
			LOGGER.error("channelId {"+channelId+"} is not found in DB");
			throw new Exception("channelId {"+channelId+"} is not found in DB");
		}
		
		return programsList;
	}
	
	/**
	 * 
	 * @param programId
	 * @return
	 * @throws Exception
	 */
	public Program retrieveProgramById(int programId) throws Exception
	{
		Program prgm = programRepository.findOne(programId);
		if(prgm == null)
		{
			LOGGER.error("programId {"+programId+"} is not found in DB");
			throw new Exception("programId {"+programId+"} is not found in DB");
		}
		
		return prgm;
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<String> getProgramsNamesByChannelId(int channelId)
	{
		List<String> programsNamesList = new ArrayList<String>();
		
		try 
		{
			List<Program> prgms = retrieveProgramsByChannel(channelId);
			if(prgms != null && !prgms.isEmpty())
			{
				for(Program prgm : prgms)
				{
					programsNamesList.add(prgm.getTitle());
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return programsNamesList;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Program> listAllPrograms()
	{
		return (List<Program>) programRepository.findAll();
	}
	
	/**
	 * 
	 * @param programId
	 * @return
	 */
	public List<CbcNew> getProgramNewsByProgramId(int programId)
	{
		return programNewsRepo.findByProgramId(programId);
	}
}
