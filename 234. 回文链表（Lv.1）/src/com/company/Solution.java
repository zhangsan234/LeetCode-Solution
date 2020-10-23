package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/23 11:47
 */

/**
 * @problem
 * 请判断一个链表是否为回文链表。
 * @example
 * 输入: 1->2
 * 输出: false
 *
 * 输入: 1->2->2->1
 * 输出: true
 * @idea
 * 快慢指针：
 * 先使用快慢指针寻找到最中间的节点，将链表分为两个链表 list1 ， list2。
 * 将 list2 翻转，将其与 list1 比较。
 * 然后将list2还原，返回结果
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        ListNode leftNode = findmidNode(head);
        ListNode rightNode = reservelist(leftNode.next);

        ListNode p1 = head;
        ListNode p2 = rightNode;
        boolean result = true;
        while(p2 != null && result){
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        reservelist(rightNode);
        return result;
    }

    private ListNode reservelist(ListNode head) {
        ListNode pren = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tempnext = curr.next;
            curr.next = pren;
            pren = curr;
            curr = tempnext;
        }
        return pren;
    }

    public ListNode findmidNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
