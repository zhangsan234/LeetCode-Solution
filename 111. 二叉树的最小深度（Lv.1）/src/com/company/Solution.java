package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/21 9:47
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @problem
 *给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @example
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度 2.
 *
 * @idea
 *  BFS
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        int deepth = 1;
        while(queue != null){
            TreeNode cur = queue.poll();
            if(cur == null){
                deepth++;
                if(queue.peek() != null){
                    queue.offer(null);
                }
            }else if(cur.left == null && cur.right == null){
                return deepth;
            }else{
                if(cur.left != null)queue.offer(cur.left);
                if(cur.right != null)queue.offer(cur.right);
            }
        }
        return deepth;
    }
}