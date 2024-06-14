package com.wooseok.algorithm.programmers.algorithm.stack.day4;

import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        String s1 = "()()"; //true
        String s2 = "(())()"; //true
        String s3 = ")()("; //false
        String s4 = "(()("; //false
        String s5 = "((((((((((((((((((((((((((((((((((((((((((((()(((((((((((((((((()(((((((((((("; //false
        System.out.println("solution1 = " + solution(s1));
        System.out.println("solution2 = " + solution(s2));
        System.out.println("solution3 = " + solution(s3));
        System.out.println("solution4 = " + solution(s4));
        System.out.println("solution5 = " + solution(s5));
    }

    static boolean solution(String s){
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
