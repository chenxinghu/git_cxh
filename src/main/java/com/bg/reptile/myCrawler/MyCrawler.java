package com.bg.reptile.myCrawler;

import java.util.Scanner;
import java.util.Set;

public class MyCrawler {
	private void initCrawlerWithSeeds(String[] seeds) {
		for (int i = 0; i < seeds.length; i++)
			LinkQueue.addUnvisitedUrl(seeds[i]);
	}

	public void crawling(String[] seeds) {
		// �������������ȡ��http://www.baidu.com��ͷ������Ϊ��
		LinkFilter filter = new LinkFilter() {
			public boolean accept(String url) {
				if (url.startsWith("http://www.baidu.com")
						|| url.startsWith("http://www.sina.com")
						|| url.startsWith("http://www.google.com"))
					return true;
				else
					return false;
			}
		};
		// ���Ի�url����
		initCrawlerWithSeeds(seeds);
		// ѭ����������ץȡ�����Ӳ�Ϊ���Ҳ�����2000
		while (!LinkQueue.unVisitedEmpty()
				&& LinkQueue.getVisitedURLNum() <= 2000) {
			String visitedurl = (String) LinkQueue.unVisitedUrlDeQueue();
			if (visitedurl == null) {
				continue;
			}
			DownLoadFile downloader = new DownLoadFile();
			// ������ҳ
			downloader.downloadFile(visitedurl);
			LinkQueue.addVisistedUrl(visitedurl);
			Set<String> links = HtmlParserTool.extracLinks(visitedurl, filter);
			for (String link : links) {
				LinkQueue.addUnvisitedUrl(link);
				System.out.println(link);
			}
		}
	}

	public static void main(String[] args) {
		try{
			MyCrawler crawler = new MyCrawler();
			String[] seedUrl = new String[3];
			String temp = null;
			System.out.println("Inputthe seed URL:");
			Scanner in = new Scanner(System.in);
			temp = in.next();
			seedUrl[0] = temp;
			System.out.println("SpiderProgram started!");
			crawler.crawling(seedUrl);
			System.out.println("SpiderProgram Ended!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
