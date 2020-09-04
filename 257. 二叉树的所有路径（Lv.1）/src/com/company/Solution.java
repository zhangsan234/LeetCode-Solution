package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/4 18:27
 */

/**
 * @problem
 *给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @example
 *输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @idea
 *  回溯深度优先搜索：
 *      对根节点开始展开深度优先遍历；
 *      用一个集合lists记录行走过的节点。
 *      每遇见一个子叶节点便将当前的lists集合转化为字符串，将该字符串加入结果集ans中
 *      然后开始回溯，并将当前加入lists中的节点删除。
 *      最后返回结果集ans。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

class Solution {
    //结果集
    List<String> ans = new LinkedList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ans;
        //记录途径路径
        List<Integer> list = new LinkedList<Integer>();
        //开始深度优先搜索
        DFS(list,root);
        return ans;
    }

    private void DFS(List<Integer> list, TreeNode root) {
        list.add(root.val);
        //若该节点为子叶点则添加字符串
        if(root.left == null && root.right == null){
            String s = generate(list);
            ans.add(s);
        }else{
             if(root.left != null) {
                 DFS(list,root.left);
                 //删除多当前经过的节点
                 list.remove(list.size() - 1);
             }
             if(root.right != null){
                 DFS(list,root.right);
                 list.remove(list.size() - 1);
             }
        }
    }
    //生成字符串
    public String generate(List<Integer> list) {
        StringBuffer stringBuffer = new StringBuffer("");
        for(Integer i : list){
            stringBuffer.append(i);
            stringBuffer.append("->");
        }
        stringBuffer.delete(stringBuffer.length() - 2 , stringBuffer.length() );
        return stringBuffer.toString();
    }
}