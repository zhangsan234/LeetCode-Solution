package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/10 9:33
 */

/**
 * @problem
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 * @example
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * @idea
 * 双指针 + 数学推导
 * 需要两个指针：慢指针（每次移到下一个节点）、快指针（每次移到下下个节点）
 * 两个节点从链表头开始移动，若链表为环形链表，则快慢指针一定会相遇 ---------1。
 *
 * 我们可以设
 * 从 链表头 到 链表尾部到链表中的位置（环形链表开始的位置，index： A）的长度为 a 、
 * 从 链表尾部到链表中的位置 到 快慢指针相遇的位置（index：B） 的长度为 b、
 * 从 快慢指针相遇的位置 到 链表尾部到链表中的位置 的长度为 c。
 * 设慢指针移动到 B 的位置时，快指针在环形链表中移动了 n 圈。
 * 则 由 1 -------可推：
 * 慢指针移动的位移的两倍 == 快指针的位移；
 * 2（a + b） = a + b + n（b + c）
 * a = c +（n - 1）（b + c）
 *
 * 可得出结论 从链表头节点head移动到 A节点的位置的长度，恰巧可以使节点从 B 移动到 A （可能会在环形链表中移动n次）
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head , fast = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next !=null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if(fast == slow){
                ListNode prt = head;
                while(prt != slow){
                    prt = prt.next;
                    slow = slow.next;
                }
                return prt;
            }
        }
        return null;
    }
}
