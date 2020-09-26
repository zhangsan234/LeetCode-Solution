package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/26 11:29
 */


/**
 * @problem
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @example
 *给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @idea
 * 深度优先搜索 + 回溯
 * 普通的深度优先搜索
 * 回溯是在每次的方法体最后回溯本次方法体执行的变动。
 * 出现合法的结果集时 ， 不需要return ， 因为需要等到本次方法体结束 ， 进行回溯；
 */

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        DFS(root , sum);
        return ans;
    }

    public void DFS(TreeNode root , int sum){
        if(root == null) return;
        temp.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null){
            ans.add(new ArrayList<>(temp));
        }
        DFS(root.left , sum);
        DFS(root.right , sum);
        temp.remove(temp.size() - 1);
    }
}

