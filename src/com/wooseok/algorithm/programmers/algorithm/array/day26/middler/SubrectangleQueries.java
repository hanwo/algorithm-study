package com.wooseok.algorithm.programmers.algorithm.array.day26.middler;

public class SubrectangleQueries {

	private final int[][] rectangle;

	public SubrectangleQueries(int[][] rectangle) {
		this.rectangle = rectangle;
	}

	public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				rectangle[i][j] = newValue;
			}
		}
	}

	public int getValue(int row, int col) {
		return rectangle[row][col];
	}

	public static void main(String[] args) {
		int[][] rectangle = {{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
		SubrectangleQueries subrectangleQueries = new SubrectangleQueries(rectangle);
		subrectangleQueries.getValue(0, 2); // 1
		subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
		subrectangleQueries.getValue(0, 2); // 5
		subrectangleQueries.getValue(3, 1); // 5
		subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
		subrectangleQueries.getValue(3, 1); // 10
		subrectangleQueries.getValue(0, 2); // 5
	}
}
