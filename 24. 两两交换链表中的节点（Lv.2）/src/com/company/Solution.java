package com.company;

import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/10/13 10:54
 */

/**
 * @problem
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @example
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @idea
 * 递归
 *  将传入的节点和下一个节点 互换。
 *  将下一个节点作为新节点头 ， 将传入节点的next指向其下一个节点指向的节点。
 *  最后将新节点头 指向 传入节点。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = head.next;
        head.next = swapPairs(newhead.next);
        newhead.next = head;
        return newhead;
    }
}
