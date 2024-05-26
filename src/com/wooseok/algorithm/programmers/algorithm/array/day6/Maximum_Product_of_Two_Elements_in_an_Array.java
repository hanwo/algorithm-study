package com.wooseok.algorithm.programmers.algorithm.array.day6;

import java.util.ArrayList;
import java.util.Arrays;

public class Maximum_Product_of_Two_Elements_in_an_Array {
    public static void main(String[] args) {
        int[] nums1 = {3,4,5,2}; // 12
        int[] nums2 = {1, 5, 4, 5}; // 16
        int[] nums3 = {3,7}; // 12

        int i = maxProduct(nums2);
        System.out.println("i = " + i);
    }

    static int maxProduct(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 2) {
            return (nums[0]-1)*(nums[1]-1);
        }

        int x = nums[nums.length-1]-1;
        int y = nums[nums.length-2]-1;

        return x*y;
    }

}
