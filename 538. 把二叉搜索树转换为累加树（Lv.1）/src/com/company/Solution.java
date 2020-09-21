package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/21 8:57
 */

/**
 * @problem
 *给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * @example
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @idea
 *  回溯：
 *  定义一个全局变量sum用于记录比当前节点大的所有节点的和。
 *  每个节点的右节点上的所有值都会比当前节点大，所以我们需要先从右子树开始遍历。
 *  当前节点的值为 其右节点的 左子树所有节点的和 + 右子树所有节点的和
 *  递归左节点的作用是为了 保证其父节点值的正确
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        back(root);
        return root;
    }

    private void back(TreeNode root) {
        if(root != null){
            back(root.right);
            sum += root.val;
            root.val = sum;
            back(root.left);
        }
    }
}
