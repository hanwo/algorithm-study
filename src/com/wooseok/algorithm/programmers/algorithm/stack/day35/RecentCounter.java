package com.wooseok.algorithm.programmers.algorithm.stack.day35;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
	private Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();

		System.out.println("recentCounter.ping(1) = " + recentCounter.ping(1)); // 1
		System.out.println("recentCounter.ping(100) = " + recentCounter.ping(100)); // 2
		System.out.println("recentCounter.ping(3001) = " + recentCounter.ping(3001)); // 3
		System.out.println("recentCounter.ping(3002) = " + recentCounter.ping(3002)); // 3
	}


	public RecentCounter() {
		queue = new LinkedList<>();
	}

	public int ping(int t) {
		queue.offer(t);

		while (!queue.isEmpty() && queue.peek() < t - 3000) {
			queue.poll();
		}

		return queue.size();
	}
}
