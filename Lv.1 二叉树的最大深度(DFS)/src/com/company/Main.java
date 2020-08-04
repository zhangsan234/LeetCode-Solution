package com.company;

/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0 ;
        }else{
            int Depthleft = maxDepth(root.left);
            int Depthright = maxDepth(root.right);
            return Math.max(Depthleft,Depthright)+1;
        }
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
    }
}
