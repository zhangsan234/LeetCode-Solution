package com.company;

import javax.lang.model.element.NestingKind;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("cat");
        strings.add("cats");
        strings.add("and");
        strings.add("sand");
        strings.add("dog");
        List<String> wordBreaks = solution.wordBreak("catsanddog", strings);
        for(String wordbreak : wordBreaks){
            System.out.println(wordbreak);
        }
    }
}
