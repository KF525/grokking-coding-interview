package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a node, find the level order successor of the given node in the tree. The level order successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessorProblem {
    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;
        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 1));
        int keyLevel = -1;

        while (!queue.isEmpty()) {
            NodeWithLevel nodeWithLevel = queue.remove();
            if (keyLevel == -1) {
                if (nodeWithLevel.node.val == key) {
                    keyLevel = nodeWithLevel.level;
                }
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.left, nodeWithLevel.level + 1));
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.right, nodeWithLevel.level + 1));
                }
            } else {
                if (nodeWithLevel.level >= keyLevel) {
                    return nodeWithLevel.node;
                } else {
                    if (nodeWithLevel.node.left != null) {
                        queue.add(new NodeWithLevel(nodeWithLevel.node.left, nodeWithLevel.level + 1));
                    }
                    if (nodeWithLevel.node.right != null) {
                        queue.add(new NodeWithLevel(nodeWithLevel.node.right, nodeWithLevel.level + 1));
                    }
                }
            }
        }
        return null;
    }

    public TreeNode findSuccessor2(TreeNode root, int key) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean keyNodeFound = false;

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (keyNodeFound) {
                return currentNode;
            } else {
                if (currentNode.val == key) {
                    keyNodeFound = true;
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return null;
    }
}
