package com.bg.reptile.lol;

public class LolClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path="F:\\webcollector";
		LolCrawler lol=new LolCrawler(path,true);
		String name = "Chogath";//Chogath,Warwick
		lol.addSeed("http://lol.qq.com/web201310/info-defail.shtml?id=Warwick");		
		try {
			lol.start(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
