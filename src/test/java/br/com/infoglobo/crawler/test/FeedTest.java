package br.com.infoglobo.crawler.test;

import java.util.ArrayList;
import java.util.List;

import br.com.infoglobo.crawler.vo.Feed;

public class FeedTest {
	
	public static Feed getOneItemFeed() {
		Feed feed = new Feed();
		
		feed.setItem(ItemTest.getVolkswagenArteon());
		
		return feed;
	}
	
	public static List<Feed> getListItemFeed() {
		List<Feed> feeds = new ArrayList<>(2);
		
		Feed feed = new Feed();
		feed.setItem(ItemTest.getVolkswagenArteon());
		feeds.add(feed);
		
		feed = new Feed();
		feed.setItem(ItemTest.getChevroletTracker());
		feeds.add(feed);
		
		return feeds;
	}
	
	public static Feed getNullFeed() {
		return null;
	}
	
}
