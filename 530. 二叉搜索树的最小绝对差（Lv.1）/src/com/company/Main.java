package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);/*
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(11);*/

        Solution solution = new Solution();
        int minimumDifference = solution.getMinimumDifference(root);
        System.out.println(minimumDifference);

    }
}
