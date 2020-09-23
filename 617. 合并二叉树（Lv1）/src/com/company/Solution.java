package com.company;

import com.sun.source.tree.Tree;

/**
 * @author Zhangsan
 * @date 2020/9/23 9:34
 */

/**
 * @problem
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 *你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @example
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * @idea
 * 使用额外空间的深度优先搜索
 * 一旦t1 和 t2 有一个是空 ，例如：t1为空 ，那么t1就不会存在子节点，参与结果集的结果只会有t2的子节点，所以可以直接吧t2连接至结果集上
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)return t2;
        if(t2 == null)return t1;
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.right = mergeTrees(t1.right , t2.right);
        treeNode.left =mergeTrees(t1.left , t2.left);
        return treeNode;
    }
}