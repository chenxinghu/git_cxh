package com.bg.reptile.zhihu;

public class ZhihuClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path="F:\\webcollector";
		ZhihuCrawler crawler=new ZhihuCrawler(path,true);
		//crawler.addSeed("http://www.zhihu.com/question/21003086");
		//crawler.addSeed("http://www.laoyuegou.com/enter/input/RoleAdd/type/lol.html?areaId=11&name=%E8%A5%BF%E6%B9%96%E8%88%B9%E5%A4%AB");
		crawler.addSeed("http://www.laoyuegou.com/enter/search/search.html?type=lol&name=%E8%A5%BF%E6%B9%96%E8%88%B9%E5%A4%AB");
		//crawler.setRoot("download");
		//crawler.addSeed("http://www.zhihu.com/question/20660804");
		try {
			crawler.start(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
