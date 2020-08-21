package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(solution.minDepth(root));
    }
}
