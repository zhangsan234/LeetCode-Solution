package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zhangsan
 * @date 2020/9/12 9:35
 */

/**
 * @problem
 *  给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * @example
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * @idea
 * 广度优先算法
 *  定义两个变量分别记录每层节点的个数 ， 和没层节点值的总和。
 *  用queue来存储每层的节点，为null时就说明该层已经结束，如果连续有两个null说明整个树已经遍历完了
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        double sum = 0;
        double nums = 0;
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll == null){
                ans.add(sum / nums);
                sum = 0 ;
                nums = 0 ;
                queue.add(null);
                if(queue.peek() == null){
                    return ans;
                }
            }else{
                nums++;
                sum += poll.val;
                if(poll.right !=null)queue.offer(poll.right);
                if(poll.left != null) queue.offer(poll.left);
            }
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
