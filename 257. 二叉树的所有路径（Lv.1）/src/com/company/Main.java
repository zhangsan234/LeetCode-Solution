package com.company;

import com.sun.source.tree.Tree;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(5);

        System.out.println(solution.binaryTreePaths(root));
    }
}
