package br.com.crawler.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ListContentDescription extends Description {

	private List<String> content;

	public ListContentDescription(String type, List<String> content) {
		super.setType(type);
		this.content = content;
	}
}