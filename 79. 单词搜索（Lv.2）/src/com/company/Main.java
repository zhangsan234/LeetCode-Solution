package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
    };
        System.out.println(new Solution().exist(board , "ABCE"));
    }
}
