package com.wooseok.algorithm.programmers.algorithm.dynamicprogramming.day21;

public class Divisor_Game {

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;

        boolean b = divisorGame(n1);
        boolean b1 = divisorGame(n2);

        System.out.println("b = " + b);
        System.out.println("b1 = " + b1);
    }

    public static boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];

        dp[1] = false;

        // DP 배열 채우기
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    // 왜..이게 되지..?
    public static boolean divisor(int n) {
        if (n % 2 == 0) return true;
        return false;
    }
}
