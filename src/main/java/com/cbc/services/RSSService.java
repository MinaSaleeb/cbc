/**
 * 
 */
package com.cbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cbc.domain.rss.Feed;
import com.cbc.domain.rss.FeedMessage;
import com.cbc.model.CbcNew;
import com.cbc.util.RSSFeedWriter;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class RSSService 
{
	@Value("${rss.file.path}")
	private String outputXmlFilePath;
	
	@Value("${rss.title}")
	private String title;
	
	@Value("${rss.link}")
	private String link;
	
	@Value("${rss.desc}")
	private String desc;
	
	@Value("${rss.newsBaseUrl}")
	private String newsBaseUrl;
	
	@Autowired
	private CBCNewsService CBCNewsService;
	
	@Scheduled(cron = "0 0 0/2 1/1 * ?")
	//@Scheduled(cron = "0 0/5 * 1/1 * ?")
	public void constructRSSFeedFile()
	{
		List<CbcNew> rssNews = CBCNewsService.getRSSNewsList();
		if(rssNews != null && !rssNews.isEmpty())
		{
			Feed feed = new Feed(title, link, desc, null, null, null);
			
			for(CbcNew cbcNew : rssNews)
			{
				FeedMessage feedMsg = new FeedMessage();
				feedMsg.setTitle(cbcNew.getTitle());
				feedMsg.setDescription(cbcNew.getDescription());
				feedMsg.setLink(newsBaseUrl+String.valueOf(cbcNew.getId()));
				feed.getMessages().add(feedMsg);
			}
			RSSFeedWriter writer = new RSSFeedWriter(feed,outputXmlFilePath);
			try 
			{
				writer.write();
			} catch (Exception e) 
			{
				
				e.printStackTrace();
			}
		}
	}
	
	
}
