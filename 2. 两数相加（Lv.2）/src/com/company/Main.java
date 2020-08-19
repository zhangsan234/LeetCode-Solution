package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
