package br.com.infoglobo.crawler.vo;

import java.io.Serializable;
import java.util.List;

public class FeedWrapper implements Serializable{

	private static final long serialVersionUID = 4302261146991445730L;
	private List<Feed> feed;
	
	public FeedWrapper(List<Feed> feed) {
		super();
		this.feed = feed;
	}

	public List<Feed> getFeed() {
		return feed;
	}
	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feed == null) ? 0 : feed.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedWrapper other = (FeedWrapper) obj;
		if (feed == null) {
			if (other.feed != null)
				return false;
		} else if (!feed.equals(other.feed))
			return false;
		return true;
	}
	
}
