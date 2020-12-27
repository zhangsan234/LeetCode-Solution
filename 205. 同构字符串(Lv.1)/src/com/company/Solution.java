package com.company;

import java.util.HashMap;

/**
 * @author Zhangsan
 * @date 2020/12/27 15:54
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character , Character> maps = new HashMap();
        HashMap<Character , Character> mapt = new HashMap();
        int len = s.length();
        for(int i = 0 ; i < len ; i ++){
            char x = s.charAt(i) , y = t.charAt(i);
            if( ( maps.containsKey(x) && maps.get(x) != y ) || ( mapt.containsKey(y) && mapt.get(y) != x )){
                return false;
            }
            maps.put(x , y);
            mapt.put(y , x);
        }
        return true;
    }
}