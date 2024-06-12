package com.wooseok.algorithm.programmers.algorithm.search.day23;

public class Count_Negative_Numbers_in_a_Sorted_Matrix {

    public static void main(String[] args) {
        int[][] grid1 =  {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int[][] grid2 =   {{3,2},{1,0}};

//        System.out.println("i = " + countNegatives(grid1)); // 8
//        System.out.println("i1 = " + countNegatives(grid2)); // 0
        System.out.println("i1 = " + countNegatives2(grid1)); // 8
        System.out.println("i1 = " + countNegatives2(grid2)); // 0
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

    public static int countNegatives2(int[][] grid) {
        int m = grid.length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            count += countNegativesInRow(grid[i]);
        }

        return count;
    }

    private static int countNegativesInRow(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return row.length - left;
    }
}
