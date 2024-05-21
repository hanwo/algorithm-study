package com.wooseok.algorithm.programmers.algorithm.hash.day1;

import java.util.HashSet;
import java.util.Set;

public class 포켓몬 {
    public static void main(String[] args) {
        // 폰켓몬 종류를 저장할 Set
        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};
        int solution = solution(nums3);
        System.out.println("solution = " + solution);

    }

    private static int solution(int[] nums) {
        Set<Integer> uniquePokemons = new HashSet<>();

        // 폰켓몬 종류를 Set에 추가
        for (int num : nums) {
            uniquePokemons.add(num);
        }

        // 선택할 수 있는 폰켓몬의 최대 종류 수는 min(폰켓몬 종류의 수, N/2)
        return Math.min(uniquePokemons.size(), nums.length / 2);
    }
}
