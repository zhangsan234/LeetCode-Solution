package com.company;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zhangsan
 * @date 2020/10/26 18:21
 */

/**
 * @problem
 *给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 * @example
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。\
 *
 * @idea
 *  排序
 *  因为不想使用暴力算法，所以不能一遍一遍遍历，我们就需要先将数组进行排序。
 *  但是由于最后是按照 原数组的位置 输出结构，所以我们需要先使用一个二位数组记录原本的下标和其存储的数值
 *
 *  我们使用数组 ints[][2] 继续初始的 nums 的值:
 *      ints[i][0] 代表 数组中的数据
 *      ints[i][1] 代表 该数据的下标
 *
 *  然后我们将 ints 按照 ints[i][0] 的大小排序.
 *
 * 创建结果集 ret[],和 一个指针 node;
 * 遍历ints数组,i代表当前下标:
 * 当 i > 0 时: 如果当前节点和上一个节点相同 :代表 比当前节点小的数的个数 和 前一个节点的一样 , 所以只将node付给ret[ints[i][1]](将值赋给他原本在数组中所在的位置);
 *             不相同时:将 i 的值赋给 node , 因为前面有 i 个比 ints[i][0] 小的值, 将node付给ret[ints[i][1]].
 * 当 i = 1 时: ret[int[i][1]] = 0 ;
 *
 *  返回结果集 ret
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int node = -1;
        int[][] ints = new int[nums.length][2];
        for(int i = 0 ; i < nums.length ; i++){
            ints[i][0] = nums[i];
            ints[i][1] = i;
        }

        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] ret = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i ++){
            if(node == -1 || ints[i][0] != ints[i - 1][0]){
                node = i;
            }
            ret[ints[i][1]] = node;
        }


        return ret;
    }
}
