package com.wooseok.algorithm.programmers.algorithm.search.day33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Target_Indices_After_Sorting_Array {

	public static void main(String[] args) {
		int[] nums1 = {1,2,5,2,3};
		int target1 = 2;

		int[] nums2 = {1,2,5,2,3};
		int target2 = 3;

		int target3 = 5;

		// [1,2]
		System.out.println("targetIndices(nums1, target1) = " + targetIndices(nums1, target1));
		// [3]
		System.out.println("targetIndices(nums2, target2) = " + targetIndices(nums2, target2));
		// [4]
		System.out.println("targetIndices(nums2, target3) = " + targetIndices(nums2, target3));

	}

	public static List<Integer> targetIndices(int[] nums, int target) {
		List<Integer> answer = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == target) {
				answer.add(i);
			}
		}

		return answer;
	}
}
