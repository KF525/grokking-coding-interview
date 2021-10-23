package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return an array containing nodes in its right view. The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.
 */
public class RightViewBinaryTreeProblem {

    public List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) return result;
        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 1));

        while (!queue.isEmpty()) {
            NodeWithLevel nodeWithLevel = queue.remove();
            if (nodeWithLevel.node.left != null) {
                queue.add(new NodeWithLevel(nodeWithLevel.node.left, nodeWithLevel.level + 1));
            }
            if (nodeWithLevel.node.right != null) {
                queue.add(new NodeWithLevel(nodeWithLevel.node.right, nodeWithLevel.level + 1));
            }
            if (queue.peek() != null && nodeWithLevel.level != queue.peek().level) {
                result.add(nodeWithLevel.node);
            }
            if (queue.peek() == null) {
                result.add(nodeWithLevel.node);
            }
        }

        return result;
    }

    public static List<TreeNode> traverse2(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // if it is the last node of this level, add it to the result
                if (i == levelSize - 1)
                    result.add(currentNode);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }

        return result;
    }
}
