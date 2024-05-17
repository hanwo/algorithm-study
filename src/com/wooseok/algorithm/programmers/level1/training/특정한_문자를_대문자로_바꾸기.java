package com.wooseok.algorithm.programmers.level1.training;

public class 특정한_문자를_대문자로_바꾸기 {
    private static String solution(String my_string, String alp) {
        return my_string.replace(alp, alp.toUpperCase());
    }

    public static void main(String[] args) {
        String my_string = "programmers";
//        String my_string = "lowercase";
        String alp = "p";
//        String alp = "x";
        String solution = solution(my_string, alp);
        System.out.println("solution = " + solution);

    }
}
