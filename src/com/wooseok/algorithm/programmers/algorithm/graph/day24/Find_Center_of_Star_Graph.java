package com.wooseok.algorithm.programmers.algorithm.graph.day24;

public class Find_Center_of_Star_Graph {

    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}, {2, 3}, {4, 2}};
        int[][] edges2 = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};

        System.out.println("findCenter(edges1) = " + findCenter(edges1)); // 2
        System.out.println("findCenter(edges2) = " + findCenter(edges2)); // 1
    }

    public static int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
