package com.bg.reptile.myCrawler;

import java.util.LinkedList;

public class Queue {
	private LinkedList queue = new LinkedList();

	public void enQueue(Object url) {
		queue.addLast(url);
	}

	public Object deQueue() {
		return queue.removeFirst();
	}

	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	// 判断队列是否包含url
	public boolean contains(Object url) {
		return queue.contains(url);
	}
}
