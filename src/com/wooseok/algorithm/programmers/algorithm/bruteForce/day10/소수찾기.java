package com.wooseok.algorithm.programmers.algorithm.bruteForce.day10;

import java.util.Arrays;

public class 소수찾기 {

    public static void main(String[] args) {
        String number1 = "17"; // 3
        String number2 = "011"; // 2

        int solution1 = solution(number1);
        System.out.println("solution1 = " + solution1);
        int solution2 = solution(number2);
        System.out.println("solution2 = " + solution2);
    }

    static int solution(String numbers) {
        int answer = 0;
        char[] charArray = numbers.toCharArray();
        System.out.println("charArray = " + Arrays.toString(charArray));
        for (char c : charArray) {
            System.out.println("Character.getNumericValue(c) = " + Character.getNumericValue(c));
        }
        return answer;
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;			// 1보다 작으면 false 반환
        for (int i = 2; i < n; i++) {		// 2보다 크고 n보다 작은 수로 나눈다.
            if (n % i == 0) return false;		// 만약 나누어 떨어지는 것이 있다면 false 반환
        }
        return true;				// 모두 나누고도 떨어지는 수가 없다면 true 반환
    }
}
