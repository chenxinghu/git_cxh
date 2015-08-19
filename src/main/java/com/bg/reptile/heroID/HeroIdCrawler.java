package com.bg.reptile.heroID;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class HeroIdCrawler extends BreadthCrawler{

	public HeroIdCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	@Override
	public void visit(Page page, Links links) {
        String str=page.getDoc().select("ul[id=jSearchHeroDiv]").html();
        System.out.println("È«²¿Ó¢ÐÛ£º"+str);

	}

}
