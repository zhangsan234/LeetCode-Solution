package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        char[] s = new char[]{};
        Solution solution = new Solution();
        solution.reverseString(s);
        for(char c : s){
            System.out.print(c);
        }
        System.out.println();
    }
}
