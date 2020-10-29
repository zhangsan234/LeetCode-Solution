package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);
        Solution solution = new Solution();
        int i = solution.sumNumbers(treeNode);
        System.out.println(i);
    }
}
