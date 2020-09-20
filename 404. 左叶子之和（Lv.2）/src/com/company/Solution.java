package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/20 11:16
 */

/**
 * @problem
 *计算给定二叉树的所有左叶子之和。
 * @example
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @idea
 * 递归寻找合法节点
 * 合法节点：
 * 当前节点是左节点，并且当前节点没有子节点
 *
 * 如果当前节点是右节点，直接递归
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        DFS(root);
        return sum;
    }
    public void DFS(TreeNode root){
        if(root == null)return;
        if(root.left != null){
            if(root.left.right == null && root.left.left == null){
                sum += root.left.val;
            }
            DFS(root.left);
        }
        if(root.right != null){
            DFS(root.right);
        }
    }
}
