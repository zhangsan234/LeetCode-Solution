package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode root = new ListNode(1 , new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6 , new ListNode(7)))))));
        Solution solution = new Solution();
        ListNode head = solution.oddEvenList(root);
        while(head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();
    }
}
