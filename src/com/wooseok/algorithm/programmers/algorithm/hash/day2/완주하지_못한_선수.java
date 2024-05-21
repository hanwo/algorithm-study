package com.wooseok.algorithm.programmers.algorithm.hash.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public interface 완주하지_못한_선수 {

    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"}; // "leo"
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"}; // vinko
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"}; // mislav
        String[] completion1 = {"eden", "kiki"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        String solution = solution(participant2, completion2);
        System.out.println("solution = " + solution);
    }
    static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return null;
    }

}
