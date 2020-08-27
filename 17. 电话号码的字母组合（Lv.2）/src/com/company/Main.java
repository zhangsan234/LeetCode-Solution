package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("23");
        for(String s : strings){
            System.out.println(s);
        }
    }
}
