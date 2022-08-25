package com.wooseok.algorithm.programmers.level1.dataStructure.stack;

import java.util.*;
/**
 * 문제 설명
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
 *
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 배열 arr의 크기 : 1,000,000 이하의 자연수
 * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 */
public class 같은숫자는싫어 {
    public static int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        int temp = -1;                              // 0부터 시작이라고 했으니 0으로 비교하면 안됨
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != temp) {
                answer.add(arr[i]);
                temp = arr[i];
            }
        }
        System.out.println("answer.stream().mapToInt(i -> i).toArray() = " + Arrays.toString(answer.stream().mapToInt(i -> i).toArray()));

        // 스택 풀이
        /**
         * 아래 스트림 변환 방식이랑 비교했을때 비교도 안될 정도로 빨랐다..
         */
//        Stack<Integer> S = new Stack<>();
//        S.push(arr[0]);
//        for(int i=1;i<arr.length;i++){
//            if(S.peek()!=arr[i])S.push(arr[i]);
//        }
//        int[] answer =new int[S.size()];
//        for(int i=0;i<S.size();i++){
//            answer[i]=S.get(i);
//        }

        return answer.stream().mapToInt(i -> i).toArray();          // mapToInt -> 스트림을 IntStream으로 변환해주는 메서드 -------------> 해당 변환 방법은 갓구글께서 ㅎ
    }

    public static void main(String[] args){
        int [] arr = {1, 1, 3, 3, 0, 1, 1};                 //[1,3,0,1]
//        int [] arr = {4, 4, 4, 3, 3};                     //[4,3]
        int [] sol = solution(arr);
        for (int i : sol) {
            System.out.println("i = " + i);
        }
    }
}
