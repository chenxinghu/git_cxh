package com.bg.reptile.heroID;

import com.bg.reptile.zhihu.ZhihuCrawler;

public class HeroIdClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path="F:\\webcollector";
		HeroIdCrawler crawler=new HeroIdCrawler(path,true);
		crawler.addSeed("http://lol.qq.com/web201310/info-heros.shtml");
		//crawler.setRoot("download");
		//crawler.addSeed("http://www.zhihu.com/question/20660804");
		try {
			crawler.start(5);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
