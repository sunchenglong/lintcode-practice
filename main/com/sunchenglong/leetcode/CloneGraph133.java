package com.sunchenglong.leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/8/16.
 */
public class CloneGraph133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, ArrayList> map = new HashMap<UndirectedGraphNode, ArrayList>();
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();

        return result;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};