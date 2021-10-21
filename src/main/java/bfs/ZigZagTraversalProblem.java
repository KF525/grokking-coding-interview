package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its zigzag level order traversal. You should populate the values of all nodes of the first level from left to right, then right to left for the next level and keep alternating in the same manner for the following levels.
 */
public class ZigZagTraversalProblem {
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.offer(new NodeWithLevel(root, 1));
        List<Integer> nodesAtLevel = new ArrayList<>();
        int currentLevel = 1;
        boolean right = true;

        while (!queue.isEmpty()) {
            //still collecting nodes at this level
            if (queue.peek().level == currentLevel) {
                NodeWithLevel nodeWithLevel = queue.remove();
                //determine whether to zig or zag...
                if (right) {
                    nodesAtLevel.add(0, nodeWithLevel.node.val);
                } else {
                    nodesAtLevel.add(nodeWithLevel.node.val);
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.right, currentLevel + 1));
                }
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.left, currentLevel + 1));
                }
            } else {
                result.add(nodesAtLevel);
                right = !right;
                currentLevel++;
                nodesAtLevel = new ArrayList<>();
            }
        }

        result.add(nodesAtLevel);
        return result;
    }
}
