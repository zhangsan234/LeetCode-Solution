package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhangsan
 * @date 2020/9/28 9:22
 */


/**
 * @problem
 *给定一个二叉树
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @example
 *
 *  输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * @idea
 *  使用队列层级遍历。
 *  遍历到每层的最左边的节点（也就是本层的链表的头节点）时 ， 直接将队列现存的所有节点获取 ， 从左到右依次遍历 。
 *  遍历时：
 *      因为链表需要从本层的从左向右连接， 所以向队列queue添加的元素 也是先添加节点的左节点 ， 然后是右节点 。
 *      需要判断节点的左右节点是否为空，队列中不需要出现null节点，
 *      队列为空时，结束遍历
 *  最终返回root即可
 */
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cunt = queue.size();
            Node cur_n = queue.peek();
            for(int i = 0 ; i < cunt ; i++){
                Node f = queue.poll();
                if(f.left != null)queue.add(f.left);
                if(f.right != null)queue.add(f.right);
                if(cur_n != f) {
                    cur_n.next = f;
                    cur_n = f;
                }
            }
        }
        return root;
    }
}
