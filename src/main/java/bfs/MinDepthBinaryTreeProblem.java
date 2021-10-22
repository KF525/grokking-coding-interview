package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
 */
public class MinDepthBinaryTreeProblem {
    public int findDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 1));

        while (!queue.isEmpty()) {
            NodeWithLevel nodeWithLevel = queue.remove();
            if (nodeWithLevel.node.left == null &&
                    nodeWithLevel.node.right == null) {
                return nodeWithLevel.level;
            } else{
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.left,
                            nodeWithLevel.level + 1));
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.right,
                            nodeWithLevel.level + 1));
                }
            }
        }
        //should never reach here
        return -1;
    }
}
