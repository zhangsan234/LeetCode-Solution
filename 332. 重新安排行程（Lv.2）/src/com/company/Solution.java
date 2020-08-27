package com.company;

/**
 * @author Zhangsan
 * @date 2020/8/27 10:12
 */

import java.util.*;

/**
 * @problem
 *
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *(每一张机票都要使用)
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 *
 * @example
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 * @idea
 * 欧拉图 ,欧拉路径
 *
 * 通过图中所有边恰好一次且行遍所有顶点的通路称为欧拉通路。
 * 通过图中所有边恰好一次且行遍所有顶点的回路称为欧拉回路。
 *
 * 解法:
 * 本题可以看成有向图：
 * 用hashmap存储 每个点 和 其所有路径 的对应关系
 * 用PriorityQueue（排序队列）存储其所有路径，每次poll都会取出队列中最小的那个元素。
 *
 * 我们每走一步 都会将这条路径删除 而路径的最后一个节点，一定是没有其他路径的节点，死胡同就是整个路径的最后一个节点。
 * 所以我们可以逆序入栈
 *
 * 对于节点来说 从它的每一个 非死胡同分支出发进行深度优先搜索，最后都会回到当前点，而多余死胡同分支进行深度优先搜索，则会结束。所以死胡同分支
 * 上的节点会优先其他分支入栈，而结果只会存在一个死胡同，我们就可以逆序入栈
 *
 * 由上可知入栈的条件为：
 * 当前点不存在hashmap集合中（因为最后一个节点没有其他路径了，hashmap中就没有它的k，v ，证明它是最后一个节点）
 * 当前节点的其他路径为0 即queue.size() == 0 当前节点是最后一个节点
 *
 */
class Solution {
    Map<String,PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String from = ticket.get(0), to = ticket.get(1);
            if(!map.containsKey(from)){
                map.put(from,new PriorityQueue<String>());
            }
            map.get(from).offer(to);
        }
        DFS("JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void DFS(String cur) {
        while(map.containsKey(cur) && !map.get(cur).isEmpty()){
            String poll = map.get(cur).poll();
            DFS(poll);
        }
        //逆序入栈
        ans.add(cur);
    }
}