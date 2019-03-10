package br.com.crawler.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FeedWrapper {
	private List<Feed> feed;
}
