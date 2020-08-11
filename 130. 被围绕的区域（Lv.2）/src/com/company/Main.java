package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        char[][] chars = {
                {'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', '0', '0', 'X'},
                {'X', '0', 'X', 'X'}
        };
        solution.solve(chars);
        for(int i  = 0 ; i < chars.length ; i++){
            for(int j =  0 ;  j < chars[0].length ; j++){
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
