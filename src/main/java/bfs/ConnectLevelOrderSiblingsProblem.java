package bfs;


import bfs.util.NodePointerWithLevel;
import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;
import bfs.util.TreeNodeWithPointer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, connect each node with its level order successor. The last node of each level should point to a null node.
 */
public class ConnectLevelOrderSiblingsProblem {

    public void connect(TreeNodeWithPointer root) {
        if (root == null) return;
        Queue<NodePointerWithLevel> queue = new LinkedList<>();
        queue.add(new NodePointerWithLevel(root, 1));
        int currentLevel = 1;
        TreeNodeWithPointer previous = null;

        while (!queue.isEmpty()) {

            if (queue.peek() != null && queue.peek().level == currentLevel) {
                NodePointerWithLevel nodeWithLevel = queue.remove();
                if (previous != null) {
                    previous.next = nodeWithLevel.node;
                }
                previous = nodeWithLevel.node;
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodePointerWithLevel(nodeWithLevel.node.left, currentLevel + 1));
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodePointerWithLevel(nodeWithLevel.node.right, currentLevel + 1));
                }
            } else {
                currentLevel++;
                previous = null;
            }
        }
    }
}
