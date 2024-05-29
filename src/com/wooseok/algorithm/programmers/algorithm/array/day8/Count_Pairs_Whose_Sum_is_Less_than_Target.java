package com.wooseok.algorithm.programmers.algorithm.array.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count_Pairs_Whose_Sum_is_Less_than_Target {
    public static void main(String[] args) {
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(-1, 1, 2, 3, 1));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(-6, 2, 5, -2, -7, -1, 3));
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(9, -5, -5, 5, -5, -4, -6, 6, -6));

        int target1 = 2;
        int target2 = -2;
        int target3 = 3;

        int i = countPairs(nums1, target1); // 3
        int j = countPairs(nums2, target2); // 10
        int k = countPairs(nums3, target3); // 27

        PairCounter pairCounter1 = new PairCounter(nums1, target1);
        PairCounter pairCounter2 = new PairCounter(nums2, target2);
        PairCounter pairCounter3 = new PairCounter(nums3, target3);

        int result = pairCounter1.countPairs(); // 3
        int result2 = pairCounter2.countPairs(); // 10
        int result3 = pairCounter3.countPairs(); // 27

    }

    static int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            int first = nums.get(i);
            for (int j = 0; j < nums.size(); j++) {
                int last = nums.get(j);
                if (i < j && first + last < target) {
                    count++;
                }
            }
        }
        return count;
    }

    // 다른 풀이법
    public static class PairCounter {

        private final List<Integer> nums;
        private final int target;

        public PairCounter(List<Integer> nums, int target) {
            this.nums = nums;
            this.target = target;
        }

        public int countPairs() {
            int count = 0;
            int size = nums.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (nums.get(i) + nums.get(j) < target) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
