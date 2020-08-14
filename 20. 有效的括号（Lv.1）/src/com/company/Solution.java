package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author Zhangsan
 * @date 2020/8/14 10:05
 */
public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n%2 == 1)return false;
        //哈希映射。
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < n ; ++i){
            char a = s.charAt(i);
            if(map.containsKey(a)){
                if(stack.isEmpty() || stack.peek() != map.get(a)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(a);
            }
        }
        return stack.isEmpty();
    }
}
