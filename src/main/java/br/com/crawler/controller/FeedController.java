package br.com.crawler.controller;

import br.com.crawler.service.FeedService;
import br.com.crawler.vo.FeedWrapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.crawler.constants.UrlConstants.FEED;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FeedController{
	
	private FeedService service;

	@GetMapping(FEED)
	public FeedWrapper get() {
		return new FeedWrapper(service.getFeed());
	}
}