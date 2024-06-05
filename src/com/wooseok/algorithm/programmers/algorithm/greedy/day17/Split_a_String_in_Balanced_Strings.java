package com.wooseok.algorithm.programmers.algorithm.greedy.day17;

import java.util.ArrayList;

public class Split_a_String_in_Balanced_Strings {
    public static void main(String[] args) {

        String s1 = "RLRRLLRLRL";
        String s2 = "RLRRRLLRLL";
        String s3 = "LLLLRRRR";

        int i = balancedStringSplit(s1);
        int i1 = balancedStringSplit(s2);
        int i2 = balancedStringSplit(s3);

        System.out.println("i = " + i); // 4
        System.out.println("i1 = " + i1); // 2
        System.out.println("i2 = " + i2); // 1

    }

    public static int balancedStringSplit(String s) {
        ArrayList<String> balancedString = new ArrayList<>();
        int balance = 0;
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char[] charArray = s.toCharArray();

            // 선택 절차
            // 문자열을 순회하면서 'L'과 'R'의 개수를 세다가 서로 개수가 같아지면 그 위치에서 문자열을 나눕니다.
            if (charArray[i] == 'R') {
                balance++;
            }
            if (charArray[i] == 'L') {
                balance--;
            }

            // 적절성 검사
            // 각 부분 문자열이 균형 잡힌 문자열인지 확인합니다.
            if (balance == 0) {
                balancedString.add(s.substring(index, i + 1));
                index = i + 1;
            }
        }

        // 해답 검사
        System.out.println("balancedString = " + balancedString);

        return balancedString.size();
    }

    public static int enhancedBalancedStringSplit(String s) {
        int answer = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                balance++;
            }

            if (s.charAt(i) == 'L') {
                balance--;
            }

            // 적절성 검사: 균형이 맞으면 카운트를 증가시킵니다.
            if (balance == 0) {
                answer++;
            }
        }

        return answer;
    }
}
