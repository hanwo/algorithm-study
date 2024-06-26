package com.wooseok.algorithm.programmers.algorithm.array.day38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Delete_Greatest_Value_in_Each_Row {

	public static void main(String[] args) {

		int[][] grid1 = {{1, 2, 4}, {3, 3, 1}};
		int[][] grid2 = {{10}};
		int[][] grid3 =
			{
				{1, 3, 5, 7},
				{2, 4, 6, 8},
				{3, 5, 7, 9,},
				{4, 6, 8, 10},
				{50, 35, 15, 39},
				{44, 53, 21, 33},
				{11, 22, 44, 33}
			};

		// 8
		System.out.println("deleteGreatestValue(grid1) = " + deleteGreatestValue(grid1));
		// 10
		System.out.println("deleteGreatestValue(grid2) = " + deleteGreatestValue(grid2));
		// 150
		System.out.println("deleteGreatestValue(grid3) = " + deleteGreatestValue(grid3));

	}

	public static int deleteGreatestValue(int[][] grid) {
		int answer = 0;
		int rows = grid.length; // 행 7
		int cols = grid[0].length; // 열 4

		for (int[] arr : grid) {
			Arrays.sort(arr);
		}


		for (int j = 0; j < cols; j++) {
			int max = 0;
			List<Integer> maxArray = new ArrayList<>();
			for (int i = 0; i < rows; i++) {
				max = grid[i][grid[i].length - 1];
				grid[i] = removeLastElement(grid[i]);
				maxArray.add(max);
			}
			max = Collections.max(maxArray);
			answer += max;
		}

		return answer;
	}

	public static int[] removeLastElement(int[] array) {
		if (array.length == 0) {
			return array;
		}

		int[] newArray = new int[array.length - 1];
		System.arraycopy(array, 0, newArray, 0, array.length - 1);

		return newArray;
	}
}
