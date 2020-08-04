package com.company;

import java.util.Scanner;
import java.util.Stack;

/*
    使用栈实现队列的下列操作：

    push(x) -- 将一个元素放入队列的尾部。
    pop() -- 从队列首部移除元素。
    peek() -- 返回队列首部的元素。
    empty() -- 返回队列是否为空。
 */
class MyQueue {
    private  int front;
    Stack<Integer> p1;
    Stack<Integer> p2;
    /** Initialize your data structure here. */
    public MyQueue() {
        p1 = new Stack<>();
        p2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (p1.empty())
            front = x;
        p1.push(x);
    }



    /** Removes the element from in front of queue and returns that element. */
    public void pop() {
        if (p2.isEmpty()) {
            while (!p1.isEmpty())
                p2.push(p1.pop());
        }
        p2.pop();
    }


    /** Get the front element. */
    public int peek() {
        if (!p2.isEmpty()) {
            return p2.peek();
        }
        return front;
    }


    /** Returns whether the queue is empty. */
    public boolean empty() {
        return p1.empty() && p2.empty();
    }
}



public class Main {

    public static void main(String[] args) {
	// write your code here
        MyQueue myQueue = new MyQueue();
        System.out.println("1.入列");
        System.out.println("2.出列");
        System.out.println("3.peek()");
        System.out.println("4.队列是否为空");
        int i ;
        do {
            System.out.println("请输入您的操作");
            i = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (i){
            case 1 :
                System.out.println("请输入入列值：");
                myQueue.push(Integer.parseInt(new Scanner(System.in).nextLine()));
                break;
            case 2:
                myQueue.pop();
                break;
            case 3:
                System.out.println(myQueue.peek());
                break;
            case 4:
                myQueue.empty();
                break;
                }
        }while ( i!= -1);
    }
}
