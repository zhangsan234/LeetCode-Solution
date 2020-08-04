package com.company;

/**
 * @Auther: Zwh
 * @Date: 2020/08/04/11:30
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题目
 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

 示例
 输入: 2, [[1,0]]
 输出: true
 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

 思路
 利用拓扑排序，整个图中若存在拓扑排序则不存在全部选完的情况(相互之间套娃)
 每个节点有三种状态：
    0状态表示还没有遍历；
    1状态表示当前节点和其子节点在遍历中
    2表示当前节点已经遍历完了
 可以使用深度优先遍历（也可使用广度优先遍历）对每一个0状态的节点进行遍历，遍历时当前系节点状态转为1。若存在拓扑结构（及下一个遍历节点状态也是1）则直接return；返回false；
 遍历结束后当前节点的状态转化为2，及表示当前节点遍历已经完成

 */
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < numCourses ; ++i){
            edges.add(new ArrayList<Integer>());
        }
        for(int[] inf : prerequisites){
            edges.get(inf[1]).add(inf[0]);
        }
        visited = new int[numCourses];
        for(int i = 0 ; i < numCourses ; ++i ){
            if(visited[i] == 0 ){
                DFS(i);
            }
        }return valid;
    }
    public void DFS(int i){
        visited[i] = 1 ;

        for(int a :edges.get(i)){
            if(visited[a] == 0 ){
                DFS(a);
                if(!valid){
                    return;
                }
            }else if(visited[a] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.canFinish(2,new int[][]{
                {1,0},
                {0,1}
        }));
    }
}
