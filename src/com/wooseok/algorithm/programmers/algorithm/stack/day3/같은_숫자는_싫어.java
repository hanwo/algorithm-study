package com.wooseok.algorithm.programmers.algorithm.stack.day3;

import java.util.Arrays;
import java.util.Collections;

import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};
        int[] answer = solution(arr2);
        for (int i : answer) {
            System.out.println("answer = " + i);
        }

    }

    static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i : arr) {
            if(stack.peek() != i) stack.push(i);
        }

        int[] answer = new int[stack.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.pop();
        }

        int[] reversedAnswer = new int[answer.length];
        for (int i = 0; i < answer.length; i++) {
            reversedAnswer[i] = answer[answer.length - 1 - i];
        }

        return reversedAnswer;
    }
}
