package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
    }
}
