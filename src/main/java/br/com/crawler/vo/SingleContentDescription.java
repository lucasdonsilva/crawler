package br.com.crawler.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SingleContentDescription extends Description {

	private String content;

    public SingleContentDescription(String type, String content) {
        super.setType(type);
        this.content = content;
    }
}