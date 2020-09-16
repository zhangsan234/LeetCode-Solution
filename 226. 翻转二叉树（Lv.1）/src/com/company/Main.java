package com.company;

import com.sun.source.tree.Tree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        Solution solution = new Solution();
        TreeNode newroot = solution.invertTree(root);
    }
}
