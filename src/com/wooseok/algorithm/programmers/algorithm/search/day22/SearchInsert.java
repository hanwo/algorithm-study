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

        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
    }

    public static int searchInsert(int[] nums, int target) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }

            if(nums[nums.length-1] < target){
                return nums.length;
            }

            if(nums[i] < target && nums[i+1] > target) {
                return i+1;
            }
        }
        return answer;
    }
}
