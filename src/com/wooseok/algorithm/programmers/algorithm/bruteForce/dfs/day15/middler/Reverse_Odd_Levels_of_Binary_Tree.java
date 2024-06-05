package com.wooseok.algorithm.programmers.algorithm.bruteForce.dfs.day15.middler;


import java.util.ArrayList;
import java.util.HashSet;

public class Reverse_Odd_Levels_of_Binary_Tree {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        2,3,5,8,13,21,34,11,22,33,44,55,66,77,88
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        TreeNode treeNode = reverseOddLevels(root, "root");
        System.out.println("treeNode = " + treeNode);
    }

    public static TreeNode reverseOddLevels(TreeNode root, String name) {
        if (root == null) {
            return null;
        }

        reverseOddLevels(root.right, "right");
        reverseOddLevels(root.left, "left");
        int i = maxDepth(root);
        System.out.println(name + "   i = " + i + " root.val: " + root.val + " root.left: " + root.left + " root.right:" + root.right);

        if (i % 2 == 0) {
            ArrayList<Integer> test = new ArrayList<>();
            test.add(root.val);
            System.out.println("test.toString() = " + test.toString());
        }

        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        System.out.println("MAX~!!!!!!!!!!!!!!!!");

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> remain = make(n, lost);
        return answer(n, lost, reserve, remain);
    }

    private static HashSet<Integer> make(int n, int[] lost) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // 각 요소에 1부터 n까지의 값을 할당
        }

        HashSet<Integer> arrList = new HashSet<>();
        for (int num : arr) {
            arrList.add(num);
        }

        // lost에 있는 학생들을 리스트에서 제거
        for (int num : lost) {
            arrList.remove(num);
        }

        return arrList;
    }

    private static int answer(int n, int[] lost, int[] reserve, HashSet<Integer> remain) {
        ArrayList<Integer> reserveRemain = new ArrayList<>();

        for (int i : reserve) {
            reserveRemain.add(i);
        }

        for (int k : lost) {
            if (reserveRemain.contains(k)) {
                reserveRemain.remove(Integer.valueOf(k));
            }
        }

        for (int k : lost) {
            for (int j = 0; j < reserveRemain.size(); j++) {
                if (k + 1 == reserveRemain.get(j) || k - 1 == reserveRemain.get(j)) {
                    remain.add(k);
                    reserveRemain.remove(reserveRemain.get(j));
                }
            }
        }

        return remain.size();
    }

}
