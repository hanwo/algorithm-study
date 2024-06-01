package com.wooseok.algorithm.programmers.algorithm.bruteForce.dfs.day13;

public class Evaluate_Boolean_Binary_Tree {
    public static void main(String[] args) {
        // 0 = false, 1 = true, 2 = OR, 3 = AND
        // 2,1,3,null,null,0,1
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        boolean evaluate = evaluateTree(root);
        System.out.println("evaluate = " + evaluate);
    }

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

    public static boolean evaluateTree(TreeNode root) {
        if (root.val == 0) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }

        boolean leftEval = evaluateTree(root.left);
        boolean rightEval = evaluateTree(root.right);

        if (root.val == 2) {  // OR 연산
            return leftEval || rightEval;
        }
        if (root.val == 3) {  // AND 연산
            return leftEval && rightEval;
        }
        return false;
    }
}
