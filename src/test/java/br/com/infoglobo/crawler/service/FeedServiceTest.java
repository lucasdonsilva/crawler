package br.com.infoglobo.crawler.service;

import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.infoglobo.crawler.exception.IntegrationException;
import br.com.infoglobo.crawler.service.FeedService;
import br.com.infoglobo.crawler.service.FeedServiceImpl;
import br.com.infoglobo.crawler.test.FeedTest;
import br.com.infoglobo.crawler.vo.Feed;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedServiceTest{
	
	@Autowired
	private FeedService feedService;
	
	@Value("${feed.one-item-feed}")
	private URL oneItemURL;
	
	@Value("${feed.list-item-feed}")
	private URL listItemURL;
	
	@Value("${feed.null-feed}")
	private URL nullFeed;
	
	@Value("${feed.invalid-url}")
	private URL invalidURL;
	
	@Before
	public void setUp() {
		((FeedServiceImpl)feedService).setUrl(null);
	}
	
	@Test
	public void getFeedOneItem() {
		((FeedServiceImpl)feedService).setUrl(oneItemURL);
		
		List<Feed> feeds = feedService.getFeed();
		
		Assert.assertTrue(!feeds.isEmpty() && feeds.size() == 1);
		Assert.assertTrue(FeedTest.getOneItemFeed().equals(feeds.get(0)));
	}
	
	@Test
	public void getFeedListItem() {
		((FeedServiceImpl)feedService).setUrl(listItemURL);
		
		List<Feed> feeds = feedService.getFeed();
		
		Assert.assertTrue(!feeds.isEmpty() && feeds.size() == 2);
		Assert.assertTrue(FeedTest.getListItemFeed().equals(feeds));
	}
	
	@Test
	public void getFeedNull() {
		((FeedServiceImpl)feedService).setUrl(nullFeed);
		
		List<Feed> feeds = feedService.getFeed();
		
		Assert.assertTrue(feeds.isEmpty());
	}
	
	@Test(expected=IntegrationException.class)
	public void getFeedInvalidUrl() {
		((FeedServiceImpl)feedService).setUrl(invalidURL);
		
		feedService.getFeed();
	}

}
