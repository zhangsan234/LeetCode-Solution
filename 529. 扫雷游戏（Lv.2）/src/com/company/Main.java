package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        char[][] chars = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        solution.updateBoard(chars,new int[]{3,0});
        for(char[] y : chars){
            for(char x : y){
                System.out.print("\'"+x+"\'  ");
            }
            System.out.println();
        }
    }
}
