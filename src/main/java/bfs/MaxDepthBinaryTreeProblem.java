package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth (or height).
 */
public class MaxDepthBinaryTreeProblem {
    public int findDepth(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = 0;
        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 1));

        while (!queue.isEmpty()) {
            NodeWithLevel nodeWithLevel = queue.remove();
            if (nodeWithLevel.node.left == null && nodeWithLevel.node.right == null) {
                maxDepth = Math.max(maxDepth, nodeWithLevel.level);
            } else {
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.left, nodeWithLevel.level + 1));
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.right, nodeWithLevel.level + 1));
                }
            }
        }

        return maxDepth;
    }
}
