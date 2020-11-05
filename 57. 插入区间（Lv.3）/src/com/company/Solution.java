package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/11/4 12:31
 */

/**
 * @problem
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @example
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * @idea
 * 模拟：
 *  遍历intervals，如果和newinterval没有重叠区域，则直接加入结果集。
 *  若有重叠区域，则重新计算newinterval的区间大小，最后加入结果集中
 *
 *  将结果集转化为二维数组并返回
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}