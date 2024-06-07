package com.wooseok.algorithm.programmers.algorithm.dynamicprogramming.day19;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {

    public static void main(String[] args) {
        int numRows1 = 5;
        int numRows2 = 1;

        List<List<Integer>> generate1 = generate(numRows1);
        List<List<Integer>> generate2 = generate(numRows2);
        System.out.println("generate = " + generate1.toString());
        System.out.println("generate = " + generate2.toString());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();

        for (int n = 0; n < numRows; n++) {
            // 열
            List<Integer> row = new ArrayList<>(n + 1);
            // 최상단
            if (n == 0) {
                row.add(1);
            } else {
                for (int k = 0; k <= pascal.size(); k++) {
                    // 전 ArrayList 값 가져오기
                    List<Integer> before = pascal.get(n - 1);
                    if (k == 0 || k == pascal.size()) {
                        row.add(1);
                    } else {
                        row.add(before.get(k - 1) + before.get(k));
                    }
                }
            }
            pascal.add(row);
        }

        return pascal;
    }
}