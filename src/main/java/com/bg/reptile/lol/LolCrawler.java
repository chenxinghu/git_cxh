package com.bg.reptile.lol;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class LolCrawler extends BreadthCrawler{

	public LolCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	@Override
	public void visit(Page page, Links links) {
		System.out.println("正在抽取"+page.getUrl());
        /*抽取标题*/
        String title=page.getDoc().title();
        System.out.println("标题："+title);
        /*抽取提问内容*/
        String data=page.getDoc().select("dl[id=DATAinfo]").html();
        //String question=page.getDoc().getElementById("zh-question-detail").text();
        String story=page.getDoc().getElementById("DATAlore").html();
        System.out.println("英雄具体数据:"+data);
        System.out.println("英雄故事："+story);
		
	}

}
