package com.wooseok.algorithm.programmers.algorithm.array.day8.middler;

import java.util.Arrays;
import java.util.Comparator;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        int solution = solution(citations);
        System.out.println("solution = " + solution);
    }

    static int solution(int[] citations) {
        int answer = 0;
        //기본 int 배열에서는 내림차순을 사용할 수 없다.
        Integer[] arr = Arrays.stream(citations)
            .boxed()
            .sorted(Comparator.reverseOrder()) //6,5,3,1,0
            .toArray(Integer[]::new);

        for(int i = 0 ; i < arr.length ; i++) {
            if(i <= arr[i]) {
                answer = i+1;
            }
        }
        return answer;
    }
}
