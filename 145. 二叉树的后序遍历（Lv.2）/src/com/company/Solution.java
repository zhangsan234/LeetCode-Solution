package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/29 10:19
 */


/**
 * @problem
 *  给定一个二叉树，返回它的 后序 遍历。
 * @example
 *  输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * @idea
 * 方法一：递归
 * 方法二：morris算法
 */
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
    List<Integer> ans = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        DFS(root);
        return ans ;
    }

    private void DFS(TreeNode root) {
        if(root == null)return;
        if(root.left != null )DFS(root.left);
        if(root.right != null)DFS(root.right);
        ans.add(root.val);
    }
}
