package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(7);
        Solution solution = new Solution();
        solution.connect(node);
    }
}
