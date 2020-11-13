package com.company;

/**
 * @author Zhangsan
 * @date 2020/11/13 22:57
 */

/**
 * @problem
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * @example
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * @idea
 * 将偶数节点单独提出 连成链表。
 * 最终将两个链表连接返回
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /**
     * 不保持相对顺序
     */
/*    public ListNode oddEvenList(ListNode head) {
        ListNode root = head;
        ListNode index = root.next;
        root = root.next;
        int current = 1;
        while(root != null){
            if(current % 2 == 0){
                int temp  = index.val;
                index.val = root.val;
                root.val = temp;
                index = index.next;
            }
            current ++;
            root = root.next;
        }
        return head;
    }*/

    /**
     * 保持相对顺序，
     * 使用一个新节点，记录偶数下标节点
     */
    public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode evenHead = head.next;
            ListNode odd = head, even = evenHead;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }