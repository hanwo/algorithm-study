package com.wooseok.algorithm.programmers.algorithm.array.day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shuffle_the_Array {

	public static void main(String[] args) {
		int[] nums1 = {2, 5, 1, 3, 4, 7};
		int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
		int[] nums3 = {1, 1, 2, 2};

		int n1 = 3;
		int n2 = 4;
		int n3 = 2;

		System.out.println("shuffle(nums1, n1) = " + Arrays.toString(shuffle(nums1, n1)));
		System.out.println("shuffle(nums2, n3) = " + Arrays.toString(shuffle(nums2, n2)));
		System.out.println("shuffle(nums3, n3) = " + Arrays.toString(shuffle(nums3, n3)));
	}

	public static int[] shuffle(int[] nums, int n) {
		int[] arr = new int[2 * n];

		for (int i = 0; i < n; i++) {
			arr[2 * i] = nums[i];
			arr[2 * i + 1] = nums[i + n];
		}
		return arr;
	}

	public static int[] shuffle2(int[] nums, int n) {
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			left.add(nums[i - 1]);
		}

		for (int i = n; i < nums.length; i++) {
			right.add(nums[i]);
		}

		for (int i = 0; i < n; i++) {
			answer.add(left.get(i));
			answer.add(right.get(i));
		}

		return answer.stream()
			.mapToInt(x -> x)
			.toArray();
	}
}
