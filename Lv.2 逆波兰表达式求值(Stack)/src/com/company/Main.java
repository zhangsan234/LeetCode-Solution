package com.company;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        Integer op1,op2;
        for(String a : tokens){
            switch (a){
                case "+":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1+op2);
                    break;
                case "-":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1-op2);
                    break;
                case "*":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1*op2);
                    break;
                case "/":
                    op2 = s.pop();
                    op1 = s.pop();
                    s.push(op1/op2);
                    break;
                default:
                    s.push(Integer.valueOf(a));
            }
        }


        return s.pop();
    }
}



public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] s = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(s));
    }
}
