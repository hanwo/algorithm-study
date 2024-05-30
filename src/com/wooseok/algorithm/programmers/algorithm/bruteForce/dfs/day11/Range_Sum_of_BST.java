package com.wooseok.algorithm.programmers.algorithm.bruteForce.dfs.day11;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Range_Sum_of_BST {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }


        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        int i = rangeSumBST(root, low, high);
        System.out.println("i = " + i);
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        //  현재 노드의 값이 low보다 큰 경우
        // 왼쪽 자식 노드가 더 작은 값을 가지므로, 범위 내의 값을 찾기 위해 필요
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // 현재 노드의 값이 high보다 작은 경우,
        //  오른쪽 자식 노드가 더 큰 값을 가지므로, 범위 내의 값을 찾기 위해 필요
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
