package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/8/12 11:18
 *
 * @problem
 *给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 * @example
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *
 *
 * @idea
 * 由题意可知 我们需要遍历整个无向图，为了排除出现相互访问的情况 我们需要一个hashmap去记录已经遍历过的节点
 *
 * 然后我们可以通过遍历途中的每个节点，并new 一个新对象进行添加。可用DFS或BFS遍历
 *
 */

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class Solution {
    HashMap<Node,Node> hashMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        if(hashMap.containsKey(node)){
            return hashMap.get(node);
        }
        Node cloneNode = new Node(node.val , new ArrayList<Node>());
        hashMap.put(node,cloneNode);

        for(Node neigbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neigbor));
        }
    return hashMap.get(node);
    }
}
