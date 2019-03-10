package br.com.crawler.util;

import java.util.ArrayList;
import java.util.List;

import br.com.crawler.vo.Feed;

import static br.com.crawler.util.ItemMock.getChevroletTracker;
import static br.com.crawler.util.ItemMock.getVolkswagenArteon;

public class FeedMock {
	
	public static Feed getOneItemFeed() {
		return new Feed(getVolkswagenArteon());
	}
	
	public static List<Feed> getListItemFeed() {
		List<Feed> feeds = new ArrayList<>(2);
		
		feeds.add(new Feed(getVolkswagenArteon()));
		feeds.add(new Feed(getChevroletTracker()));
		
		return feeds;
	}
}