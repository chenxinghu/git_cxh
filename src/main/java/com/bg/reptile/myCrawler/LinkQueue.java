package com.bg.reptile.myCrawler;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LinkQueue {
	private static Set visitedUrl = new HashSet();
	private static Queue unvisitedUrl = new Queue();
	/**
	 * {@link #NULL}����
	 */
	public static final LinkQueue NULL;
	
	static{
		NULL = new LinkQueue();
	}

	private static PriorityQueue unVisitedURL = new PriorityQueue();

	public static Queue getUnVisistedUrl() {
		return unvisitedUrl;
	}

	// ��ӵ����ʹ���URL������
	public static void addVisistedUrl(String url) {
		visitedUrl.add(url);
	}

	// �Ƴ����ʹ���URL
	public static void removeVisistedUrl(String url) {
		visitedUrl.remove(url);
	}

	// δ���ʹ���URL������
	public static Object unVisitedUrlDeQueue() {
		return unvisitedUrl.deQueue();
	}

	// ��֤ÿ��URLֻ������һ��
	public static void addUnvisitedUrl(String url) {
		if (url != null && !url.trim().equals("") && !visitedUrl.contains(url)
				&& !unvisitedUrl.contains(url)) {
			unvisitedUrl.enQueue(url);
		}
	}

	// ����Ѿ���λ��URL��Ŀ
	public static int getVisitedURLNum() {
		return visitedUrl.size();
	}

	// ����δ���ʵ�URL�����Ƿ�Ϊ��
	public static boolean unVisitedEmpty() {
		return unvisitedUrl.isQueueEmpty();
	}
}
