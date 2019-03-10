package br.com.crawler.util;

import br.com.crawler.vo.Item;

import static br.com.crawler.util.DescriptionMock.getChevroletTrackerContents;
import static br.com.crawler.util.DescriptionMock.getVolkswagenArteonContents;

class ItemMock {
	
	static Item getVolkswagenArteon() {
		Item item = new Item();
		
		item.setTitle("Volkswagen Arteon aparece às vésperas do Salão de Genebra");
		item.setLink("http://revistaautoesporte.globo.com/Noticias/noticia/2017/03/volkswagen-arteon-aparece-vesperas-do-salao-de-genebra.html");
		item.setDescriptions(getVolkswagenArteonContents());
		
		return item;
	}
	
	static Item getChevroletTracker() {
		Item item = new Item();
		
		item.setTitle("Chevrolet Tracker ganha isenções para PCD e parte de R$ 72.346");
		item.setLink("http://revistaautoesporte.globo.com/Noticias/noticia/2017/11/chevrolet-tracker-ganha-isencoes-para-pcd-e-parte-de-r-72346.html");
		item.setDescriptions(getChevroletTrackerContents());
		
		return item;
		
	}
}
