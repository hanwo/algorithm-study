package com.wooseok.algorithm.programmers.level1;

import java.util.*;

public class dev_matching_로또최고순위와최저순위 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;        // 맞은 개수
        int zero = 0;       // 0 개수
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
            }
            for (int win_num : win_nums) {
                if (win_num == lotto) {
                    cnt++;
                }
            }
        }
        answer[0] = 7 - Math.max((cnt + zero), 1);
        answer[1] = 7 - Math.max(cnt, 1);
        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};                       // [3, 5]
        //int[] lottos = {0, 0, 0, 0, 0, 0};                        // [1, 6]
        //int[] lottos = {45, 4, 35, 20, 3, 9};                     // [1, 1]

        int[] win_nums = {31, 10, 45, 1, 6, 19};
        //int[] win_nums = {38, 19, 20, 40, 15, 25};
        //int[] win_nums = {20, 9, 3, 45, 4, 35};
        int[] sol = solution(lottos, win_nums);
    }
}
