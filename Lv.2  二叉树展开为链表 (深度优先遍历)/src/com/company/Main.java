package com.company;

/*
给定一个二叉树，原地将它展开为一个单链表。

 

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> newtree = new ArrayList<>();
        DFS(newtree,root);
        int n = newtree.size();
        TreeNode newroot = new TreeNode();
        for(int i = 1 ; i < n ; ++i){
            newtree.get(i-1).right = newtree.get(i);
            newtree.get(i-1).left = null;
        }



    }

    private void DFS(List<TreeNode> newtree, TreeNode root) {
        if(root != null){
            newtree.add(root);
            if(root.left != null)DFS(newtree,root.left);
            if(root.right != null)DFS(newtree, root.right);
        }


    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);


        Solution solution = new Solution();
        solution.flatten(root);
        TreeNode example = root;
        while(example.right != null){
            System.out.println(example.val);
            example = example.right;
        }
    }
}
