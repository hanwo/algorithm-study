package com.wooseok.algorithm.programmers.algorithm.bruteForce.dfs.day12;

public class Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
//    public static void main(String[] args) {
//        Integer[] originalArray = {8,null,6,null,5,null,4,null,3,null,2,null,1};
//        Integer[] clonedArray = {8,null,6,null,5,null,4,null,3,null,2,null,1};
//        int targetVal = 4;
//        TreeNode original = buildTreeFromArray(originalArray);
//        TreeNode cloned = buildTreeFromArray(clonedArray);
//        TreeNode target = findTarget(original, targetVal);
//        TreeNode result = getTargetCopy(original, cloned, target);
//        System.out.println("result = " + (result != null ? result.toString() : null));
//    }

    public static void main(String[] args) {
        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);

        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);

        TreeNode target = original.right;

        TreeNode result = getTargetCopy(original, cloned, target);
    }

    public static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }

        TreeNode leftResult = getTargetCopy(original.left, cloned.left, target);
        if (leftResult != null) {
            return leftResult;
        }

        return getTargetCopy(original.right, cloned.right, target);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public static TreeNode buildTreeFromArray(Integer[] arr) {
//        if (arr.length == 0 || arr[0] == null) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(arr[0]);
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        int i = 1;
//        while (!queue.isEmpty() && i < arr.length) {
//            TreeNode current = queue.poll();
//
//            if (i < arr.length && arr[i] != null) {
//                current.left = new TreeNode(arr[i]);
//                queue.add(current.left);
//            }
//            i++;
//
//            if (i < arr.length && arr[i] != null) {
//                current.right = new TreeNode(arr[i]);
//                queue.add(current.right);
//            }
//            i++;
//        }
//
//        return root;
//    }
//
//    public static TreeNode findTarget(TreeNode root, int targetVal) {
//        if (root == null) {
//            return null;
//        }
//        if (root.val == targetVal) {
//            return root;
//        }
//        TreeNode leftResult = findTarget(root.left, targetVal);
//        if (leftResult != null) {
//            return leftResult;
//        }
//        return findTarget(root.right, targetVal);
//    }
}
