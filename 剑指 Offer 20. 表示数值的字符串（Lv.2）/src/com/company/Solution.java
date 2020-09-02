package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/2 10:43
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @problem
 *请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @example
 *
 * @idea
 * 确定有限状态机
 *
 */
class Solution {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap(){{put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }},  //0.起始的blank状态
                new HashMap(){{put('d', 2); put('.', 4); }} ,                           //1.e之前的sign状态
                new HashMap(){{put('d', 2); put(' ', 8); put('.', 3); put('e', 5); }},  //2.dot（逗号）之前的digit(数字)
                new HashMap(){{put('d', 3); put('e', 5); put(' ', 8); }},               //3.dot之后的digit
                new HashMap(){{put('d', 3); }},                                         //4.当dot前面为空时，dot后的digit
                new HashMap(){{put('d', 7); put('s', 6); }},//5.e
                new HashMap(){{put('d', 7); }},//6.e之后的sign
                new HashMap(){{put('d', 7); put(' ', 8); }},//7.e之后的digit
                new HashMap(){{put(' ', 8); }}//8.尾部blank(结束)
        };
        int p = 0 ;
        char t ;
        for(char c : s.toCharArray()){
            if (c >= '0' && c <= '9')t = 'd';
            else if (c == '+' || c == '-')t = 's';
            else if (c == 'e' || c == 'E')t = 'e';
            else if (c == '.' || c == ' ')t = c;
            else t = '?';

            if(!states[p].containsKey(t))return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
