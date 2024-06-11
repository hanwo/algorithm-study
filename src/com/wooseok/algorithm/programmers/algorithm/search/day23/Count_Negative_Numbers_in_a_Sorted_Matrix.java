package com.wooseok.algorithm.programmers.algorithm.search.day23;

public class Count_Negative_Numbers_in_a_Sorted_Matrix {

    public static void main(String[] args) {
        int[][] grid1 =  {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int[][] grid2 =   {{3,2},{1,0}};

        int i = countNegatives(grid1);
        int i1 = countNegatives(grid2);

        System.out.println("i = " + i); // 8
        System.out.println("i1 = " + i1); // 0
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if(anInt < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
