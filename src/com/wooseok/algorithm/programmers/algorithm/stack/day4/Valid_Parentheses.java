package com.wooseok.algorithm.programmers.algorithm.stack.day4;

import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        String s1 = "()"; // true
        String s2 = "()[]{}"; // true
        String s3 = "(]"; // false
        String s4 = "(("; // false

        boolean valid = isValid(s4);
        System.out.println("valid = " + valid);
    }

    static boolean isValid(String s) {
        // 스택을 사용하여 여는 괄호를 저장
        Stack<Character> stack = new Stack<>();

        // 문자열의 각 문자를 순회
        for (char c : s.toCharArray()) {
            // 여는 괄호일 경우 스택에 추가
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 닫는 괄호일 경우 스택이 비어있지 않은지 확인
                if (stack.isEmpty()) {
                    return false;
                }

                // 스택에서 가장 최근의 여는 괄호를 꺼내어 짝이 맞는지 확인
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
