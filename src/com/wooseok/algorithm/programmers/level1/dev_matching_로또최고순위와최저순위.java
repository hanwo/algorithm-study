package com.wooseok.algorithm.programmers.level1;

import java.util.Arrays;

public class dev_matching_로또최고순위와최저순위 {
//    public static int[] solution(int[] lottos, int[] win_nums) {
//        int[] answer = new int[2];
//        int max_level = 6;
//        int min_level = 6;
//        for (int lotto : lottos) {
//            System.out.println("lotto = " + lotto);
//            for (int win_num : win_nums) {
//                if(win_num == lotto){
//                    if(max_level != 1){
//                        max_level--;
//                    }
//                    if(min_level != 1){
//                        min_level--;
//                    }
//                }
//                System.out.println("win_num = " + win_num);
//            }
//            if(lotto == 0){
//                if(max_level != 1){
//                    max_level--;
//                }
//            }
//            System.out.println("max_level = " + max_level);
//            System.out.println("min_level = " + min_level);
//            System.out.println("============================================");
//        }
//        answer[0]=max_level;
//        answer[1]=min_level;
//        System.out.println("answer = " + Arrays.toString(answer));
//        return answer;
//    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int level = 0;          // 순위
        int content = 0;        // 일치한 갯수
        for (int lotto : lottos) {
            for (int win_num : win_nums) {
                if(win_num == lotto){
                    content++;
                }
            }
            if(lotto == 0){
                content++;
            }
        }
        level = 7-content;
        answer[0] = level;
        answer[1] = level;
        System.out.println("content = " + content);
        return answer;
    }
    public static void main(String[]args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};                       // [3, 5]
//        int[] lottos = {0, 0, 0, 0, 0, 0};                        // [1, 6]
//        int[] lottos = {45, 4, 35, 20, 3, 9};                     // [1, 1]

        int[] win_nums = {31, 10, 45, 1, 6, 19};
//        int[] win_nums = {38, 19, 20, 40, 15, 25};
//        int[] win_nums = {20, 9, 3, 45, 4, 35};
        int[] sol = solution(lottos, win_nums);
        System.out.println("sol = " + Arrays.toString(sol));
    }
}
