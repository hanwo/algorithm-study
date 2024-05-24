package com.wooseok.algorithm.programmers.algorithm.array.day5;

import java.util.ArrayList;
import java.util.Arrays;

public class Minimum_Number_Game {
    public static void main(String[] args) {
        int[] num1 = {5,4,2,3}; // 3,2,5,4
        int[] num2 = {2,5}; // 5,2

        int[] ints = numberGame(num2);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }

    }

    static int[] numberGame(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            int alice = nums[i];
            int bob = nums[i+1];

            answer.add(bob);
            answer.add(alice);

            if(answer.size() == nums.length) {
                break;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    static int[] numberGame2(int[] nums) {

        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i+=2) // checking only for the even no[2,4,6]
        {
            int temp= nums[i];
            nums[i]= nums[i+1];
            nums[i+1]=temp;
        }
        return nums;
    }
}
