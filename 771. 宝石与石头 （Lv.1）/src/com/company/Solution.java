package com.company;

import java.util.HashSet;

/**
 * @author Zhangsan
 * @date 2020/10/2 11:24
 */

/**
 * @problem
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * @example
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * @idea
 * 哈希集合
 */
class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0  ||S == null || S.length() == 0 ){
            return 0;
        }
        int cunt = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < J.length() ; i++){
            set.add(J.charAt(i));
        }
        for(int i = 0 ; i < S.length() ; i++){
            if(set.contains(S.charAt(i))){
                cunt++;
            }
        }
        return cunt;
    }
}
