package com.wooseok.algorithm.programmers.algorithm.dynamicprogramming.day18;

import java.util.Arrays;

import static java.lang.Long.toBinaryString;

public class Counting_Bits {

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 5;

        int[] ints1 = countBits(n1);
        int[] ints2 = countBits(n2);

        System.out.println("ints1 = " + Arrays.toString(ints1));
        System.out.println("ints2 = " + Arrays.toString(ints2));
    }

    public static int[] countBits(int n) {
        int[] answer = new int[n + 1];

        for (int i = 0; i < answer.length; i++) {
            String binaryString = toBinaryString(i);
            String[] split = binaryString.split("");
            answer[i] = count(split);
        }
        return answer;
    }

    private static int count(String[] split) {
        int ans = 0;

        for (String s : split) {
            if (s.equals("1")) {
                ans++;
            }
        }

        return ans;
    }
}
