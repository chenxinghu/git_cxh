package com.bg.reptile.zhihu;

import java.util.regex.Pattern;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class ZhihuCrawler extends BreadthCrawler{

	public ZhihuCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	@Override
	public void visit(Page page, Links links) {
		String question_regex="^http://www.zhihu.com/question/[0-9]+";
        //if(Pattern.matches(question_regex, page.getUrl())){
            System.out.println("���ڳ�ȡ"+page.getUrl());
            /*��ȡ����*/
            String title=page.getDoc().title();
            System.out.println("���⣺"+title);
            //System.out.println("ȫ������:"+page.getDoc().html());
            /*��ȡ��������*/
            String question=page.getDoc().select("div[id=zh-question-detail]").text();
            //String question=page.getDoc().getElementById("zh-question-detail").text();

            System.out.println("question:"+question);            
        //}
	}

}
