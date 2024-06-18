package com.wooseok.algorithm.programmers.algorithm.sort.day7;

import java.util.Arrays;

public class K번째수 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		int[] answer = solution(array, commands);
		int[] answer2 = solution2(array, commands);

		System.out.println("answer = " + Arrays.toString(answer));
		System.out.println("answer = " + Arrays.toString(answer2));
	}

	static int[] solution(int[] array, int[][] commands) {
		return Arrays.stream(commands)
			.mapToInt(command -> {
				int i = command[0] - 1;
				int j = command[1];
				int k = command[2] - 1;
				int[] ints = Arrays.copyOfRange(array, i, j);
				Arrays.sort(ints);
				int anInt = ints[k];
				return anInt;
			})
			.toArray();
	}

	static int[] solution2(int[] array, int[][] commands) {
		Arrays.sort(array);
		return Arrays.stream(commands)
			.mapToInt(command -> {
				int[] slicedArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
				Arrays.sort(slicedArray);
				return slicedArray[command[2] - 1];
			})
			.toArray();
	}

}
