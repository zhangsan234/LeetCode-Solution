package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

class Solution {
    private HashMap<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node clonenode = new Node(node.val,new ArrayList<>());
        visited.put(node,clonenode);

        for(Node neighbor : node.neighbors){
            clonenode.neighbors.add(cloneGraph(neighbor));
        }

    return clonenode;
    }
}


public class Main {


    public static void main(String[] args) {
	// write your code here
    }
}
