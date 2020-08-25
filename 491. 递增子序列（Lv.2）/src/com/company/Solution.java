package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/8/25 10:27
 */

/**
 * @problem
 *  给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * @example
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * @idea
 * 递归
 * 对于整个数组进行遍历递归，枚举整个组数；为寻找到该数组的递增子序列，所以每个元素都有三种状态：
 * 1.该元素比前一个元素值大，选择该元素
 * 2.该元素比前一个元素值大，不选择该元素
 * 3.该元素比前一个元素值小，不选这该元素
 * （最重要的就是状态，有了这种状态才能枚举所有可能的情况）
 * 若已经选择了该元素，则枚举完当前元素被选择的所有情况之后，回溯，
 * 并将该元素从子序列中删除，开始枚举该元素没有被选择的情况。
 *
 * 我们需要一个变量cur记录当前节点的位置，我们枚举整个数组的所有情况
 * 最后我们将合法的递增子序列添加进结果集中，合法的条件为：
 * 1.已经枚举到了数组的最后一个元素,即：cur == nums.lenght;
 * 2.该子序列的元素大于等于2 即 temp.size() >= 2
 * */

class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}