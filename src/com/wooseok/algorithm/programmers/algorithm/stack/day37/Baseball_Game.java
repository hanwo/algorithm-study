package com.wooseok.algorithm.programmers.algorithm.stack.day37;

import java.util.ArrayDeque;
import java.util.Deque;

public class Baseball_Game {

	public static void main(String[] args) {

		String[] operations1 = {"5", "2", "C", "D", "+"};
		String[] operations2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
		String[] operations3 = {"1", "C"};

		// 30
		System.out.println("calPoints(operations1) = " + calPoints(operations1));
		// 27
		System.out.println("calPoints(operations2) = " + calPoints(operations2));
		// 0
		System.out.println("calPoints(operations3) = " + calPoints(operations3));

	}

	public static int calPoints(String[] operations) {
		int answer = 0;
		Deque<Integer> score = new ArrayDeque<>();
		for (String operation : operations) {
			switch (operation) {
				case "C" -> score.removeLast();
				case "D" -> score.add(score.peekLast() * 2);
				case "+" -> {
					Integer last = score.pollLast();
					Integer lastAfter = score.pollLast();
					score.add(lastAfter);
					score.add(last);
					score.add(last + lastAfter);
				}
				default -> score.add(Integer.parseInt(operation));
			}
		}

		answer = plus(score);
		return answer;
	}

	private static Integer plus(Deque<Integer> score) {
		Integer answer = 0;
		for (Integer i : score) {
			answer += i;
		}
		return answer;
	}
}
