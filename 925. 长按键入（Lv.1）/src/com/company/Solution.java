package com.company;

/**
 * @author Zhangsan
 * @date 2020/10/21 11:12
 */

/**
 * @problem
 *你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * @example
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * @idea
 * 双指针
 *  在指针向后移动的过程中，只会出现三种情况：
 *      1、两指针指向的值相同。两指针都向后移动一个
 *      2、两指针指向的值不同，type指针的值和前一个值相同，type指针向后移动一个，
 *      3、不符合题目要求，返回false；
 *  如果最后name的指针移动到了最后，说明符合题目要求
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int index_name = 0 ;
        int index_type = 0 ;
        while( index_type < typed.length()){
            if(index_name < name.length() && name.charAt(index_name) == typed.charAt(index_type)){
                index_name ++;
                index_type ++;
            }else if(index_type > 0 && typed.charAt(index_type) == typed.charAt(index_type - 1)){
                index_type ++;
            }else {
                return false;
            }
        }
        return index_name == name.length();
    }
}
