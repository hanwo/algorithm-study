package com.wooseok.algorithm.programmers.algorithm.hash.day2;

import java.util.Arrays;
import java.util.HashSet;

public interface 완주하지_못한_선수 {

    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"}; // "leo"
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"}; // vinko
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"}; // mislav
        String[] completion1 = {"eden", "kiki"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        String solution = solution(participant3, completion3);
        System.out.println("solution = " + solution);
    }

    static String solution(String[] participant, String[] completion) {
        HashSet<String> part = new HashSet<>(Arrays.asList(participant));
        HashSet<String> com = new HashSet<>(Arrays.asList(completion));

        HashSet<String> substract = new HashSet<>(part);
        substract.removeAll(com);

        System.out.println(substract);
        String answer = "";
        return answer;
    }

}
