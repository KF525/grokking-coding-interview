package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest level comes first. You should populate the values of all nodes in each level from left to right in separate sub-arrays.
 */
public class ReverseLevelOrderProblem {
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;

        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 1));
        int currentLevel = 1;
        List<Integer> nodesAtLevel = new ArrayList<>();

        while (!queue.isEmpty()) {
            if (queue.peek().level == currentLevel) {
                //still collecting nodes at this level, add node
                NodeWithLevel nodeWithLevel = queue.remove();
                nodesAtLevel.add(nodeWithLevel.node.val);
                //enqueue children that are not null
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.left, currentLevel + 1));
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.right, currentLevel + 1));
                }
            } else {
                //done with collecting nodes at current level
                result.add(0, nodesAtLevel);
                nodesAtLevel = new ArrayList<>();
                currentLevel++;
            }
        }

        result.add(0, nodesAtLevel);
        return result;
    }
}
