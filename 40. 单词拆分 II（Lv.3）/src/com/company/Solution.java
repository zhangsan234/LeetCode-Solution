package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/11/1 15:40
 */

/**
 * @problem
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * @example
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 *
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 *
 * @idea
 *  如果直接使用回溯 如果遇见：
 *      输入：s = ”ssssssssssssssssssssssssssssssssssssss“
 *           words = {“ss” ， “s”}
 *   肯定会超时，所以可以使用记忆化的搜索。
 *
 *   使用的数据结构:
 *      使用一个哈希表记录 对应下标 ，对应下标之后可以组成的单词组合，
 *      使用一个hashset记录 words 中出现的单词
 *
 *   从 0 下标开始递归，对于下标index，若map集合中已经存在该点的记录，可以直接跳过。若没有记录，则开始向后遍历，当找到一个完整的单词时，开始向后递归，
 *   得到该单词下标之后的所有可以组成的单词组，将得到的所有单词组的最前面都添加上找到的完整单词，将添加好的单词组放入map集合中，并返回map集合中该下标的值。
 *
 *
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //记录每个下标index 之后可以组成的单词组
        HashMap<Integer , List<List<String>>> map = new HashMap<>();
        //记录worddict中的单词
        HashSet<String> wordset = new HashSet<>(wordDict);
        //结果集
        List<String> ret = new LinkedList<>();
        //开始递归
        List<List<String>> wordsbreak = black(s , s.length() , wordset , 0 , map);
        for(List<String> words : wordsbreak){
            ret.add(String.join(" " , words));
        }
        return ret;
    }

    private List<List<String>> black(String s, int length, HashSet<String> wordset, int index, HashMap<Integer, List<List<String>>> map) {
        //判断是否已经搜索过该点, 若有可以直接获取该点之后所有可以组成的单词组
        if(!map.containsKey(index)){
            //存放index之后可以组成的 单词组集合
            List<List<String>> wordbreaks = new LinkedList<>();
            //index == length  直接添加一个空的单词组
            if(index == length){
                wordbreaks.add(new LinkedList<>());
            }
            //寻找index之后的一个完整单词
            for(int i = index + 1 ; i <= length ; i ++){
                String word = s.substring(index , i);
                //寻找到一个完整单词
                if(wordset.contains(word)){
                    //开始递归,返回i之后的所有单词组
                    List<List<String>> nextwordbreaks = black(s , length , wordset , i , map);
                    //将所有单词组的开始下标添加word
                    for(List<String> nextwordbreak : nextwordbreaks){
                        LinkedList<String> wordbreak = new LinkedList<>(nextwordbreak);
                        wordbreak.offerFirst(word);
                        //将 添加好的单词组 添加 至单词组集合
                        wordbreaks.add(wordbreak);
                    }
                }
            }
            //将该下标的搜索记录 记录进map中
            map.put(index , wordbreaks);
        }
        return map.get(index);
    }
}
