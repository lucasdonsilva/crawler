package br.com.crawler.service;

import java.net.URL;
import java.util.List;

import br.com.crawler.exception.IntegrationException;
import br.com.crawler.util.FeedMock;
import br.com.crawler.vo.Feed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static br.com.crawler.util.FeedMock.getListItemFeed;
import static br.com.crawler.util.FeedMock.getOneItemFeed;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		feedService.setUrl(null);
	}

	@Test
	public void getFeedOneItem() {
		feedService.setUrl(oneItemURL);
		
		List<Feed> feeds = feedService.getFeed();

		assertTrue(!feeds.isEmpty() && feeds.size() == 1);
		assertEquals(getOneItemFeed(), feeds.get(0));
	}
	
	@Test
	public void getFeedListItem() {
		feedService.setUrl(listItemURL);
		
		List<Feed> feeds = feedService.getFeed();
		
		assertTrue(!feeds.isEmpty() && feeds.size() == 2);
		assertEquals(getListItemFeed(), feeds);
	}
	
	@Test
	public void getFeedNull() {
		feedService.setUrl(nullFeed);
		
		List<Feed> feeds = feedService.getFeed();
		
		assertTrue(feeds.isEmpty());
	}
	
	@Test(expected = IntegrationException.class)
	public void getFeedInvalidUrl() {
		feedService.setUrl(invalidURL);

		feedService.getFeed();
	}
}