package com.wooseok.algorithm.programmers.algorithm.stack.day34;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Number_of_Students_Unable_to_Eat_Lunch {

	public static void main(String[] args) {

		int[] students1 = {1,1,0,0};
		int[] student2 = {1,1,1,0,0,1};


		int[] sandwich1 = {0,1,0,1};
		int[] sandwich2 = {1,0,0,0,1,1};

		System.out.println("countStudents(students1, sandwich1) = " + countStudents(students1, sandwich1));
		System.out.println("countStudents(student2, sandwich2) = " + countStudents(student2, sandwich2));
	}

	public static int countStudents(int[] students, int[] sandwiches) {
		Deque<Integer> studentQueue = new ArrayDeque<>();
		Deque<Integer> sandwichStack = new ArrayDeque<>();

		for (int student : students) {
			studentQueue.offer(student);
		}

		for (int i = sandwiches.length - 1; i >= 0; i--) {
			sandwichStack.push(sandwiches[i]);
		}

		int attempts = 0;
		int maxAttempts = students.length;

		while (!studentQueue.isEmpty() && attempts < maxAttempts) {
			if (Objects.equals(studentQueue.peek(), sandwichStack.peek())) {
				studentQueue.poll();
				sandwichStack.pop();
				attempts = 0;
			} else {
				studentQueue.offer(studentQueue.poll());
				attempts++;
			}
		}

		return studentQueue.size();
	}
}
