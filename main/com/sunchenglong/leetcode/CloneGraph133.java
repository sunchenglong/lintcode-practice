package com.sunchenglong.leetcode;

import java.util.*;

/**
 * Created by Chenglong Sun on 2016/8/16.
 */
public class CloneGraph133 {
    private Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return DfsClone(node);
    }

    UndirectedGraphNode DfsClone(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if(map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(DfsClone(neighbor));
        }
        return clone;
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