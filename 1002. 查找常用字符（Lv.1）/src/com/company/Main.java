package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strings = new String[]{"bella","label","roller"};
        Solution solution = new Solution();
        List<String> strings1 = solution.commonChars(strings);
        for(String s : strings1){
            System.out.println(s);
        }
    }
}
