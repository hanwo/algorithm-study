package com.wooseok.algorithm.programmers.algorithm.array.day27;

public class Number_of_Good_Pairs {

	public static void main(String[] args) {

		int[] nums1 = {1, 2, 3, 1, 1, 3};
		int[] nums2 = {1, 1, 1, 1};
		int[] nums3 = {1, 2, 3};

		System.out.println("numIdenticalPairs(nums1) = " + numIdenticalPairs(nums1)); // 4
		System.out.println("numIdenticalPairs(nums2) = " + numIdenticalPairs(nums2)); // 6
		System.out.println("numIdenticalPairs(nums3) = " + numIdenticalPairs(nums3)); // 0
	}

	public static int numIdenticalPairs(int[] nums) {
		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					answer++;
				}
			}
		}

		return answer;

	}
}
