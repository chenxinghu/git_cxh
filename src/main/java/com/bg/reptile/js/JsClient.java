package com.bg.reptile.js;

public class JsClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path="F:\\webcollector";
		JsCrawler lol=new JsCrawler(path,true);
		String name = "Heimerdinger";
		lol.addSeed("http://lol.qq.com/biz/hero/"+name+".js");		
		lol.addParam("F://eclipse_workspace//webcollector//src//main//webapp/js",name,"js");
		try {
			lol.start(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void parseJs(String name){
		if(null == name && "".equals(name)){
			return;
		}
		String path="F:\\webcollector";
		JsCrawler lol=new JsCrawler(path,true);
		//String name = "Heimerdinger";
		lol.addSeed("http://lol.qq.com/biz/hero/"+name+".js");		
		lol.addParam("F://eclipse_workspace//webcollector//src//main//webapp/js",name,"js");
		try {
			lol.start(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
