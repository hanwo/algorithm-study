package com.wooseok.algorithm.programmers.algorithm.bruteForce.day10;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        int[] ints = supoja2(answers);
    }

//    static int[] supoja(int[] answers) {
//        int[] answer = new int[3];
//        int[] supoja1 = {1, 2, 3, 4, 5};
//        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
//        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
//
//        answer[0] = calculate(supoja1, answers);
//        answer[1] = calculate(supoja2, answers);
//        answer[2] = calculate(supoja3, answers);
//
//        return answer;
//    }
//
//    static int calculate(int[] supoja, int[] answers) {
//        int supojaCount = 0;
//        int j = 0;
//
//        for (int i = 0; i < supoja.length; i++) {
//            int score = supoja[i];
//            if (i > answers.length - 1) {
//                j = i - answers.length;
//            }
//
//            if (score == answers[j]) {
//                supojaCount++;
//            }
//            j++;
//        }
//
//        return supojaCount;
//    }

    static int[] make(int[] scores) {
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static int[] supoja2(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                scores[0]++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                scores[1]++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                scores[2]++;
            }
        }

        return make(scores);
    }
}
