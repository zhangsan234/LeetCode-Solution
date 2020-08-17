package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/17 10:02
 *
 * @problem
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * @example
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回false 。
 *
 * @idea
 * 递归深度优先查询
 * 例如当前有节点root，先递归判断当前节点是否平衡。再遍历其子节点，判断子节点是否平衡。
 */

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}

class Solution {
   public boolean isBalanced(TreeNode root) {
       if (root == null) return true;
       return Math.abs(DFS(root.left) - DFS(root.right))<= 1 && isBalanced(root.right) && isBalanced(root.left);
   }
   private int DFS(TreeNode root){
       if (root == null)return 0;
       return Math.max(DFS(root.right),DFS(root.left)) + 1;
   }
}
