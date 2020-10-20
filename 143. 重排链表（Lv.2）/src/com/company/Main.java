package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode listNode = new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode(4))));
        Solution solution = new Solution();
        solution.reorderList(listNode);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
