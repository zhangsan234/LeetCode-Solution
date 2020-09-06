package com.company;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zhangsan
 * @date 2020/9/6 12:13
 */

/**
 * @problem
 *给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 *
 * @example
 *例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @idea
 *  主要思路：广度优先搜索
 *  使用一个集合承载下一层的所有节点，当递归到 当前层数节总数 为0时，开始回溯。
 *  在回溯的过程中，将当前层节点集合的val放入一个新 list集合中，将该集合放入结果集中。
 *  最终返回结果集。
 *
 *  注：结果要求当前层数的节点要从左到右显示，所以添加当前层数节点到list集合中时，应该也是从左往右进行添加。
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)return lists;
        List<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        BFS(treeNodes);
        return lists;
    }

    private void BFS(List<TreeNode> treeNodes) {
        if(treeNodes.size() == 0)return;
        List<TreeNode> list = new LinkedList<>();
        for(TreeNode treeNode : treeNodes){
            if(treeNode.left != null)list.add(treeNode.left);
            if(treeNode.right != null)list.add(treeNode.right);
        }
        BFS(list);
        List<Integer> ans = new LinkedList<>();
        for(TreeNode treeNode : treeNodes){
            ans.add(treeNode.val);
        }
        lists.add(ans);
    }
}
