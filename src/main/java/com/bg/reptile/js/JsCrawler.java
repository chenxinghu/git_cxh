package com.bg.reptile.js;

import com.bg.reptile.util.FileUtil;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;

public class JsCrawler extends BreadthCrawler{
	public String path;
	public String name;
	public String suffix;
	public JsCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	@Override
	public void visit(Page page, Links links) {
		String response = page.getHtml();
		System.out.println("js:"+response);
		FileUtil.write(response, path, name, suffix);
	}
	
	public void addParam(String path,String name,String suffix){
		this.path = path;
		this.name = name;
		this.suffix = suffix;
	}
	
	public String[] getParam(Page page){
		String url = page.getUrl();
		System.out.println("url:"+url);
		String[] sub = url.split("\\/");
		if(null != sub){
			return sub[1].split(".");
		}else{
			System.out.println("String[] sub = url.split(\\/); ²Ù×÷Ö®ááÎª¿Õ");
		}
		return null;
	}

}
