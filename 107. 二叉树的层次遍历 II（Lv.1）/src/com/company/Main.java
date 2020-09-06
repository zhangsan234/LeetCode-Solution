package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().levelOrderBottom(null));
    }
}
