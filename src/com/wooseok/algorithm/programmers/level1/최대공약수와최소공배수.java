package com.wooseok.algorithm.programmers.level1;

import java.util.Arrays;

public class 최대공약수와최소공배수 {

    public static void main(String[] args) {
        int n =4;
        int m =6;

        System.out.println("solution(n,m) = " + Arrays.toString(solution(n, m)));
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        int max = Math.max(n,m);
        int min = Math.min(n,m);
        answer[0] = Euclidean(max, min);
        answer[1] = lcm(max, min);
        return answer;
    }

    private static int Euclidean(int a, int b) {
        if (b == 0)
            return a;
        return Euclidean(b, a % b);
    }

    private static int lcm(int max, int min) {
        return (max * min) / Euclidean(max, min);
    }

}
