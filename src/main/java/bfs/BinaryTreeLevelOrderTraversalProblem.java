package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;

import java.util.*;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */
public class BinaryTreeLevelOrderTraversalProblem {
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 1));
        int currentLevel = 1;
        List<Integer> nodesAtLevel = new ArrayList<>();

        while (!queue.isEmpty()) {
            if (queue.peek().level == currentLevel) {
                //remove if node at front of queue is at this level and add to current list
                NodeWithLevel nodeWithLevel = queue.remove();
                nodesAtLevel.add(nodeWithLevel.node.val);
                //add children if they exist
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.left, currentLevel +1));
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.right, currentLevel +1 ));
                }
            } else {
                //we are at the next level, done with current list, increment our current level
                result.add(nodesAtLevel);
                nodesAtLevel = new ArrayList<>();
                currentLevel++;
            }
        }

        //add the last level
        result.add(nodesAtLevel);
        return result;
    }

    public List<List<Integer>> traverse2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // add the node to the current level
                currentLevel.add(currentNode.val);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevel);
        }

        return result;
    }
}
