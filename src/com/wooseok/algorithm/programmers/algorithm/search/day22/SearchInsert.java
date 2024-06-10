package com.wooseok.algorithm.programmers.algorithm.search.day22;

public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        int target1 = 5;
        int target2 = 2;
        int target3 = 7;

        int i = searchInsert(nums, target1);
        int i1 = searchInsert(nums, target2);
        int i2 = searchInsert(nums, target3);

        System.out.println("i = " + i); // 2
        System.out.println("i1 = " + i1); // 1
        System.out.println("i2 = " + i2); // 4
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                end = middle - 1;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
        }
        return start;
    }
}
