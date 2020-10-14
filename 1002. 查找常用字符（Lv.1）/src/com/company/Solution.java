package com.company;

import java.util.*;

/**
 * @author Zhangsan
 * @date 2020/10/14 10:51
 */

/**
 * @problem
 *给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 * @example
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * @idea
 * 计数 寻找每个字符串中每个字母的最小出现次数
 */
class Solution {
    public List<String> commonChars(String[] A) {
        ArrayList<String> strings = new ArrayList<>();
        int[] minfre = new int[26];
        Arrays.fill(minfre , Integer.MAX_VALUE);
        for(String word : A){
            int[] fre = new int[26];
            for(int i = 0 ; i < word.length() ; i++){
                fre[word.charAt(i) - 'a']++;
            }
            for(int i = 0 ; i < minfre.length ;i++){
                minfre[i] = Math.min(fre[i] , minfre[i]);
            }
        }
        for(int i = 0 ; i < 26 ;i++){
            for(int j = 0 ; j < minfre[i] ;j++){
                strings.add(String.valueOf((char) ('a' + i)));
            }
        }
        return strings;
    }
}