package com.company;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = T.length;
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            if(stack.empty()){
                stack.add(i);
            }else{
                if(T[stack.peek()] < T[i]){
                    System.out.println("T = "+T[stack.peek()]);
                    while(!stack.empty() && T[stack.peek()] < T[i]){
                        a[stack.peek()] = i-stack.peek();
                        stack.pop();
                    }
                    stack.add(i);
                }else{
                    stack.add(i);
                }
            }
        }
        return a;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] a = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        int p[] = solution.dailyTemperatures(a);
        for(int i : p){
            System.out.println(i);
        }
    }
}
