package com.company;

import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/8/22 10:22
 */

/**
 * @problem
 *
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 除法运算符/表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用-作为一元运算符。例如，[1, 1, 1, 1]作为输入时，表达式-1 - 1 - 1 - 1是不允许的。
 * 你不能将数字连接在一起。例如，输入为[1, 2, 1, 2]时，不能写成 12 + 12 。

 * @example
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 *
 * @idea
 * 回溯
 * 穷举每一种可能
 * 对于除法：1.底数不能为0 2.最后的结果因为是double 不可能是相等的 误差范围小于1e-6即可。
 * 对于加减法： 因为有交换律的存在 ，因为是穷举 ， 所以对于相加的两个数的下标，是通过两层循环确定的。
 * 所以当后一个数的下标小于前一个数的下标，由交换律可推出 这两个数相加或相减的情况已经存在过了。
 */
public class Solution {
    static final int TARGET = 24 ;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        if(nums.length == 0)return false;
        List<Double> doubles = new LinkedList<Double>();
        for(int a : nums){
            doubles.add((double)a);
        }
        for(int i = 0 ; i < 4 ; ++i){
            if(solve(doubles,i)){
                for(int z : nums){
                    System.out.print( z +"   ");
                }
                return true;
            }
        }
        return false;
    }

    private boolean solve(List<Double> doubles, int k) {
        int size = doubles.size();
        if(doubles.size() == 1 )return Math.abs(doubles.get(0) - TARGET) < EPSILON;
        for(int i = 0 ; i < size ; ++i){
            for(int j = 0 ; j < size ; ++j){
                if(i != j){
                    List<Double> doubles2 = new LinkedList<Double>();
                    for(int a = 0 ; a < size ; ++a){
                        if(a != i && a != j){
                            doubles2.add(doubles.get(a));
                        }
                    }
                    if (k < 2 && i > j) {
                        continue;
                    }
                    if (k == ADD) {
                        doubles2.add(doubles.get(i) + doubles.get(j));
                    } else if (k == MULTIPLY) {
                        doubles2.add(doubles.get(i) * doubles.get(j));
                    } else if (k == SUBTRACT) {
                        doubles2.add(doubles.get(i) - doubles.get(j));
                    } else if (k == DIVIDE) {
                        if (Math.abs(doubles.get(j)) < EPSILON) {
                            continue;
                        } else {
                            doubles2.add(doubles.get(i) / doubles.get(j));
                        }
                    }

                    for(int a = 0 ; a < 4 ; ++a ){
                        if(solve(doubles2,a)){
                            for(Double z : doubles2){
                                System.out.print( z +"   ");
                            }
                            System.out.println();
                            return true;
                        }
                    }
                }
            }
        }
        return false ;
    }
}
