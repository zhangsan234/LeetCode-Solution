package com.company;

import java.util.ArrayList;

/**
 * @author Zhangsan
 * @date 2020/10/19 12:36
 */


/**
 * @problem
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * @example
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * @idea
 * 重构字符串最后将字符串进行比较，得出结果
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        ArrayList<Integer> SL = new ArrayList<>();
        ArrayList<Integer> TL = new ArrayList<>();
        impleList(SL , S);
        impleList(TL , T);
        return SL.equals(TL);
    }
    public void impleList(ArrayList<Integer> list , String s ){
        for(int i  = 0 ; i < s.length() ; i ++){
            char temp = s.charAt(i);
            if(temp == '#'){
                if(list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            }else {
                list.add(temp - 'a');
            }
        }
    }
}