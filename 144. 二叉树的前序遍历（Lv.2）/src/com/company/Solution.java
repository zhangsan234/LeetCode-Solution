package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/10/27 11:02
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




/*
    递归算法：
    比较简单，简单的栈就可以解决
class Solution {
    List<Integer> res = null;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        DFS(root);
        return res;
    }

    private void DFS(TreeNode root) {
        res.add(root.val);
        if(root.left != null){
            DFS(root.left);
        }
        if(root.right != null){
            DFS(root.right);
        }
    }
}
*/

/**
 * 迭代算法
 * 使用一个栈 模拟递归
 */

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
