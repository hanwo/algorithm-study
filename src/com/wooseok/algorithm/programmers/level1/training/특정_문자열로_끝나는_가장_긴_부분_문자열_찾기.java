package com.wooseok.algorithm.programmers.level1.training;

public class 특정_문자열로_끝나는_가장_긴_부분_문자열_찾기 {

    public static String solution(String myString, String pat) {
        int i = myString.lastIndexOf(pat);
        return myString.substring(0,i) + pat;
    }

    public static void main(String[] args) {
//        String myString = "AAAAaaaa";
        String myString = "AbCdEFG";
//        String pat = "a";
        String pat = "dE";

        String result = solution(myString, pat);
        System.out.println("result = " + result);
    }
}
