package com.wooseok.algorithm.programmers.algorithm.graph.day24.middler;

import java.util.Arrays;

public class 가장_먼_노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println("solution(n,edges) = " + solution(n, edges));
    }

    public static int solution(int n, int[][] edges) {
        if (n == 2) {
            return 1;
        }
        Arrays.sort(edges, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
//        [[1, 2], [1, 3], [2, 4], [3, 2], [3, 6], [4, 3], [5, 2]]
        int answer = 0;

//        - edges[0][0] = 1, edges[0][1] = 2
//        - edges[1][0] = 1, edges[1][1] = 3
//        - edges[2][0] = 2, edges[2][1] = 4
//        - edges[3][0] = 3, edges[3][1] = 2
//        - edges[4][0] = 3, edges[4][1] = 6
//        - edges[5][0] = 4, edges[5][1] = 3
//        - edges[6][0] = 5, edges[6][1] = 2

        return answer;
    }
}
