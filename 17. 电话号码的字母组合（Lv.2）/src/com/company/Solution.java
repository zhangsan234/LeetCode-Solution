package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhangsan
 * @date 2020/8/26 15:15
 */

/**
 * @problem
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @example
 *输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @idea
 * 回溯
 * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
 * 该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，
 * 然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
 *
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits.length() == 0 )return ans;
        Map<Character,String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(ans,map,0,digits,new StringBuffer());
        return ans;
    }

    private void backtrack(List<String> ans, Map<Character, String> map, int index, String digits, StringBuffer stringBuffer) {
        if(index == digits.length()){
            ans.add(stringBuffer.toString());
        }else{
            Character c = digits.charAt(index);
            String s = map.get(c);
            int slenght = s.length();
            for(int i = 0 ; i < slenght ; i++){
                stringBuffer.append(s.charAt(i));
                backtrack(ans, map,index + 1, digits, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }
}
