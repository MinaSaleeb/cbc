/**
 * 
 */
package com.cbc.services;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.model.AdDiv;
import com.cbc.model.ChannelsAdDiv;
import com.cbc.model.NewsCategoriesAdDiv;
import com.cbc.model.ProgramsAdDiv;
import com.cbc.repository.AdDivRepository;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class AdDivsPropagationService 
{
	private static final Logger LOGGER = Logger.getLogger(AdDivsPropagationService.class);
	
	@Autowired
	private AdDivRepository adDivRepository;
	
	public Set<String> getAdDivsCodes()
	{
		Set<String> adDivsCodesSet = new HashSet<String>();
		List<AdDiv> adDivsList = (List<AdDiv>)adDivRepository.findAll();
		if(adDivsList != null && !adDivsList.isEmpty())
		{
			for(AdDiv adDiv : adDivsList)
			{
				adDivsCodesSet.add(adDiv.getDivCode());
			}
		}
		return adDivsCodesSet;
	}
	
	public void checkMissingChnlAdDivsFromTree(List<ChannelsAdDiv> cdivs, Map<String , String> adsMap, Set<String> checkedDivCodes)
	{
		for(ChannelsAdDiv ad : cdivs) // channel ads
		 {
			 String adDivCode = ad.getAdDiv().getDivCode();
			 if(adsMap.containsKey(adDivCode))
			 {
				 if(checkedDivCodes.contains(adDivCode))
				 {
					 checkedDivCodes.remove(adDivCode);
				 }
			 }
			 else
			 {
				 adsMap.put(adDivCode, ad.getAdScript());
			 }
		 }
	}
	
	public void checkMissingPrgmAdDivsFromTree(List<ProgramsAdDiv> pdivs, Map<String , String> adsMap, Set<String> checkedDivCodes)
	{
		for(ProgramsAdDiv ad : pdivs) // channel ads
		 {
			 String adDivCode = ad.getAdDiv().getDivCode();
			 if(adsMap.containsKey(adDivCode))
			 {
				 if(checkedDivCodes.contains(adDivCode))
				 {
					 checkedDivCodes.remove(adDivCode);
				 }
			 }
			 else
			 {
				 adsMap.put(adDivCode, ad.getAdScript());
			 }
		 }
	}
	
	
	public void checkMissingNewsCategoryAdDivsFromTree(List<NewsCategoriesAdDiv> ncdivs, Map<String , String> adsMap, Set<String> checkedDivCodes)
	{
		for(NewsCategoriesAdDiv ad : ncdivs) // channel ads
		 {
			 String adDivCode = ad.getAdDiv().getDivCode();
			 if(adsMap.containsKey(adDivCode))
			 {
				 if(checkedDivCodes.contains(adDivCode))
				 {
					 checkedDivCodes.remove(adDivCode);
				 }
			 }
			 else
			 {
				 adsMap.put(adDivCode, ad.getAdScript());
			 }
		 }
	}
	
	
}
