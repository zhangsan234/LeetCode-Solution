package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/16 8:49
 */

/**
 * @problem
 *翻转一棵二叉树。
 * @example
 *输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @idea
 * 递归，每次递归将当前节点的左右子树互换，然后继续向其左右子树递归，当节点为空时返回
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        DFS(root);
        return root;
    }

    private void DFS(TreeNode root) {
        if(root == null)return;
        TreeNode mid = root.left;
        root.left = root.right;
        root.right = mid;
        DFS(root.left);
        DFS(root.right);
    }
}
