package com.wooseok.algorithm.programmers.algorithm.bruteForce.day9;

import java.util.ArrayList;
import java.util.Comparator;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}; // 400
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}; // 120
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}; // 133

        int solution1 = solution2(sizes1);
//        int solution2 = solution2(sizes2);
//        int solution3 = solution2(sizes3);
        System.out.println("solution1 = " + solution1);
//        System.out.println("solution2 = " + solution2);
//        System.out.println("solution3 = " + solution3);
    }

    static int solution(int[][] sizes) {
        ArrayList<Integer> width = new ArrayList<>(sizes.length);
        ArrayList<Integer> height = new ArrayList<>(sizes.length);

        for (int[] size : sizes) {
            width.add(size[0]);
            height.add(size[1]);
        }

        for (int i = 0; i < width.size(); i++) {
            if (width.get(i) < height.get(i)) {
                int tempWidth = width.get(i);
                int tempHeight = height.get(i);
                width.set(i, tempHeight);
                height.set(i, tempWidth);
            }
        }
        width.sort(Comparator.naturalOrder());
        height.sort(Comparator.naturalOrder());


        return width.getLast() * height.getLast();
    }

    static int solution2(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        return length * height;
    }

}
