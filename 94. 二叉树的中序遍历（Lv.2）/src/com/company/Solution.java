package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/14 8:42
 */

/**
 * @problem
 *给定一个二叉树，返回它的中序 遍历。
 * @example
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * @idea
 * 迭代
 *用一个栈模拟递归
 * 如果该节点左右两节点都已经被记录，则回溯
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
//递归方法
/**
 *
 * class Solution {
 *     List<Integer> ans = new ArrayList<Integer>();
 *     public List<Integer> inorderTraversal(TreeNode root) {
 *         if(root == null)return ans;
 *         DFS(root);
 *         return ans ;
 *     }
 *
 *     private void DFS(TreeNode root) {
 *         if(root.left !=null)DFS(root.left);
 *         ans.add(root.val);
 *         if(root.right != null)DFS(root.right);
 *     }
 * }
 *
 */
