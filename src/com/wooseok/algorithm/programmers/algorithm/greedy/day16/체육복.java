package com.wooseok.algorithm.programmers.algorithm.greedy.day16;

import java.util.Arrays;
import java.util.HashSet;

public class 체육복 {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        int n4 = 4;
        int[] lost4 = {2, 3};
        int[] reserve4 = {3, 4};

        int solution = solution(n, lost, reserve); // 5
        int solution2 = solution(n2, lost2, reserve2); // 4
        int solution3 = solution(n3, lost3, reserve3); // 2
        int solution4 = solution(n4, lost4, reserve4); // 3

        System.out.println("solution = " + solution); // 5
        System.out.println("solution2 = " + solution2); // 4
        System.out.println("solution3 = " + solution3); // 2
        System.out.println("solution4 = " + solution4); // 3
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        HashSet<Integer> lostSet = make(lost);
        HashSet<Integer> reserveSet = make(reserve);

        int answer = n - lost.length;

        for (Integer i : lost) {
            if (reserveSet.contains(i)) {
                remove(lostSet, i);
                remove(reserveSet, i);
                answer++;
            }
        }

        for (Integer i : reserveSet) {
            if (lostSet.contains(i - 1)) {
                remove(lostSet, i - 1);
                answer++;
            } else if (lostSet.contains(i + 1)) {
                remove(lostSet, i + 1);
                answer++;
            }
        }

        return answer;
    }

    private static HashSet<Integer> make(int[] arr) {
        HashSet<Integer> hash = new HashSet<>();

        for (int i : arr) {
            hash.add(i);
        }

        return hash;
    }

    private static void remove(HashSet<Integer> hash, Integer i) {
        hash.remove(i);
    }
}
