package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/1 10:46
 */

/**
 * @problem
 *给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，
 * 然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * @example
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 *
 * 输入：[1, 5, 233, 7]
 * 输出：True
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 *      最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 *
 * @idea
 *  运用递归：
 *  最终比较的是 玩家1和玩家2 最大得分的差值
 *  用一个数 turn 记录先手还是后手，先手 turn 就是 1 ，后手 turn 就是 -1 ；
 *  因为每个玩家都想取得最大成绩 ，所以每次取都要满足当前玩家取得最大值
 *  因为后手的 turn 是 -1 ，所以取最大值就是取最小值 也就是 Max{左成绩 * turn ， 右成绩 * turn} * turn ；
 */
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return total(nums , 0 , nums.length - 1 , 1) >= 0;
    }

    private int total(int[] nums, int start, int end , int turn) {
        if(start == end){
            return nums[start] * turn ;
        }
        int scorestart = nums[start] * turn + total(nums , start + 1 , end , -turn);
        int scoreend = nums[end] * turn + total(nums, start, end - 1,  -turn);
        return Math.max(scoreend * turn, scorestart * turn) * turn;
    }
}
