package com.bg.reptile.myCrawler;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LinkQueue {
	private static Set visitedUrl = new HashSet();
	private static Queue unvisitedUrl = new Queue();
	/**
	 * {@link #NULL}对象
	 */
	public static final LinkQueue NULL;
	
	static{
		NULL = new LinkQueue();
	}

	private static PriorityQueue unVisitedURL = new PriorityQueue();

	public static Queue getUnVisistedUrl() {
		return unvisitedUrl;
	}

	// 添加到访问过的URL队列中
	public static void addVisistedUrl(String url) {
		visitedUrl.add(url);
	}

	// 移除访问过的URL
	public static void removeVisistedUrl(String url) {
		visitedUrl.remove(url);
	}

	// 未访问过的URL出队列
	public static Object unVisitedUrlDeQueue() {
		return unvisitedUrl.deQueue();
	}

	// 保证每个URL只被访问一次
	public static void addUnvisitedUrl(String url) {
		if (url != null && !url.trim().equals("") && !visitedUrl.contains(url)
				&& !unvisitedUrl.contains(url)) {
			unvisitedUrl.enQueue(url);
		}
	}

	// 获得已经方位的URL数目
	public static int getVisitedURLNum() {
		return visitedUrl.size();
	}

	// 测试未访问的URL队列是否为空
	public static boolean unVisitedEmpty() {
		return unvisitedUrl.isQueueEmpty();
	}
}
