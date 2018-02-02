package br.com.infoglobo.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infoglobo.crawler.service.FeedService;
import br.com.infoglobo.crawler.vo.FeedWrapper;

@RestController
public class FeedController{
	
	@Autowired
	private FeedService feedService;

	@GetMapping("/feed")
	public FeedWrapper getFeed() {
		FeedWrapper fw = new FeedWrapper(feedService.getFeed());
		return fw;	
	}
	
}
