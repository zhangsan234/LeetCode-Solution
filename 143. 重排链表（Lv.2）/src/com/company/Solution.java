package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/10/20 12:05
 */


/**
 * @problem
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @example
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @idea
 * 线性表
 * 将列表重排列，放入集合中，可以通过下标寻找到节点。
 * 然后根据题目要求重排列
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode root = head;
        while(root != null){
            list.add(root);
            root = root.next;
        }
        int i = 0 , j = list.size() - 1;
        while(i < j){
            list.get(i).next = list.get(j);
            i ++ ;
            if(i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j -- ;
        }
        list.get(i).next = null;
    }
}
