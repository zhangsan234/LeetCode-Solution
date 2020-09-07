package com.company;

/**
 * @author Zhangsan
 * @date 2020/9/7 9:03
 */

import java.util.*;

/**
 * @problem
 *给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @example
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @idea
 *  哈希表 + 排序栈
 *  哈希表的 k 为出现的数字 ， v 为出现的频数。
 *  步骤：
 *  1.将给定集合中的所有元素遍历：
 *      并put到哈希表中 ， 若元素已经存在 则将 v + 1 ， 若元素为存在 ，则添加一个元素，其 v 为 1；
 *  2.新建一个可排序队列，其中存放的元素为一个长度为 2 的数组 ， 数组中第一个元素为出现的数字，第二个元素为该数字的频率。
 *  3.遍历map集合 ，如果queue中的元素个数小于 k ，直接将改元素offer进队列中，如果queue中的元素大于 k，则取出当前排序队列的头节点（队列中的最小节点）
 *      将其和遍历的节点的频率进行比较 ，若大于队列的头节点，则将队列的头节点删除，将遍历节点offer进入队列。
 *  4.最后将队列中的元素遍历加入数组中，该数组为结果集。
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cunt = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < cunt) {
                    queue.poll();
                    queue.offer(new int[]{num, cunt});
                }
            } else {
                queue.offer(new int[]{num, cunt});

            }
        }
        int[] ans = new int[k];
        for(int i = 0 ; i < k ; ++i)
        {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}