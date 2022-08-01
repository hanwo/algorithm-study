package com.wooseok.algorithm.programmers.level1;

import java.util.*;

/**
 * 이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
 * 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
 * <p>
 * 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
 * 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
 * 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
 * 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
 * 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
 * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
 * 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 */
public class kakao_키패드누르기 {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer += "L";
                left = number;
            } else if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                right = number;
            } else {
                /**
                 * leftdist / rightdist
                 * 접근 방식은 맞았는데 왜 거리 계산 하는 방법을 몰랐을까?
                 * 그걸 몰랐으니까 접근 방식도 사실 틀린게 아닐까?
                 */
                if (number == 0) number = 11;
                int leftdist = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
                int rightdist = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;

                if (leftdist < rightdist) {
                    answer += "L";
                    left = number;
                } else if (leftdist > rightdist) {
                    answer += "R";
                    right = number;
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = number;
                    } else {
                        answer += "R";
                        right = number;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};                  //"LRLLLRLLRRL" LRLLLRLLRRL
        //int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};                //"LRLLRRLLLRR" LRLLRRLLLRR
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};                   //"LLRLLRLLRL" LLRLLRLLRL
        // hand = "right";
        //String hand = "left";
        String hand = "right";
        solution(numbers, hand);
    }
}
