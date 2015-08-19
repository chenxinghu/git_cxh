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
		System.out.println("���ڳ�ȡ"+page.getUrl());
        /*��ȡ����*/
        String title=page.getDoc().title();
        System.out.println("���⣺"+title);
        /*��ȡ��������*/
        String data=page.getDoc().select("dl[id=DATAinfo]").html();
        //String question=page.getDoc().getElementById("zh-question-detail").text();
        String story=page.getDoc().getElementById("DATAlore").html();
        System.out.println("Ӣ�۾�������:"+data);
        System.out.println("Ӣ�۹��£�"+story);
		
	}

}
