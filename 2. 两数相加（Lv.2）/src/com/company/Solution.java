package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/19 20:48
 *
 */

/**
 * @problem
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @example
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @idea
 * 初等数学
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0 ;
        ListNode head = null;
        ListNode root = null;
        ListNode p1 = l1 , p2 = l2;
        while(l1 != null || l2 != null || add != 0){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int val = x + y + add;
            if(head == null){
                head = new ListNode(val % 10);
                root = head;
            }else {
                head.next = new ListNode(val % 10);
                head = head.next;
            }
            add = val / 10 ;
            if(l1 != null)
            l1 = l1.next;
            if(l2 != null)
            l2 = l2.next;
        }
        return root ;
    }
}
