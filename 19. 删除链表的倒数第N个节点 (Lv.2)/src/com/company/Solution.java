package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/18 11:50
 */

/**
 * @problem
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @example
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @idea
 * 快慢指针
 * 使用一个快指针，先位移n个节点
 * 使用一个慢指针，指向头节点。两个指针同时向后移动，直到快指针指到最后一个节点。
 * 此时慢指针指向的节点的下一个节点就是要删除的节点， 将该节点删除，即可
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode first = head;
        ListNode secent = temp;
        for(int i = 0 ; i < n ; i ++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            secent = secent.next;
        }
        secent.next = secent.next.next;
        return temp.next;

    }
}
