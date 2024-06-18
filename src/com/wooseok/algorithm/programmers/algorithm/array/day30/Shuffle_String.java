package com.wooseok.algorithm.programmers.algorithm.array.day30;

public class Shuffle_String {
	public static void main(String[] args) {

		String s1 = "codeleet";
		String s2 = "abc";

		int[] indices1 = {4, 5, 6, 7, 0, 2, 1, 3};
		int[] indices2 = {0, 1, 2};

		System.out.println("restoreString(s1, indices1) = " + restoreString(s1, indices1));
		System.out.println("restoreString(s2, indices2) = " + restoreString(s2, indices2));

	}

	public static String restoreString(String s, int[] indices) {
		char[] arr = new char[s.length()];
		for (int i = 0; i < indices.length; i++) {
			arr[indices[i]] = s.charAt(i);
		}
		return String.valueOf(arr);
	}
}
