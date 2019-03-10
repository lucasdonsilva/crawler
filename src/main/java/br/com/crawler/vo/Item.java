package br.com.crawler.vo;

import lombok.Data;

import java.util.List;

@Data
public class Item {
	private String title;
	private String link;
	private List<Description> descriptions;
}