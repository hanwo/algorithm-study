package com.wooseok.algorithm.programmers.algorithm.array.day32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Neither_Minimum_nor_Maximum {
	public static void main(String[] args) {
		int[] nums1 = {3, 2, 1, 4};
		int[] nums2 = {1, 2};
		int[] nums3 = {2, 1, 3};

		System.out.println("findNonMinOrMax(nums1) = " + findNonMinOrMax(nums1));
		System.out.println("findNonMinOrMax(nums2) = " + findNonMinOrMax(nums2));
		System.out.println("findNonMinOrMax(nums3) = " + findNonMinOrMax(nums3));

	}

	public static int findNonMinOrMax(int[] nums) {
		Arrays.sort(nums);
		if (nums.length <= 2) {
			return -1;
		}
		return nums[1];
	}

	public static int findNonMinOrMax2(int[] nums) {
		List<Integer> numList = new ArrayList<>(
			Arrays.stream(nums)
				.boxed()
				.toList()
		);

		int max = Collections.max(numList);
		int min = Collections.min(numList);

		numList.remove(Integer.valueOf(max));
		numList.remove(Integer.valueOf(min));

		if (numList.isEmpty()) {
			return -1;
		}

		return numList.getFirst();
	}
}
