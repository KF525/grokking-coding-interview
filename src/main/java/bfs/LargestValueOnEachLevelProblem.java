package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;
import com.sun.java.accessibility.util.TopLevelWindowListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find the largest value on each level of a binary tree.
 */
public class LargestValueOnEachLevelProblem {

    public List<Integer> getLargestLevelValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 1));
        int maxLevelValue = Integer.MIN_VALUE;
        int currentLevel = 1;

        while (!queue.isEmpty()) {
            if (queue.peek().level == currentLevel) {
                NodeWithLevel nodeWithLevel = queue.remove();
                maxLevelValue = Math.max(nodeWithLevel.node.val, maxLevelValue);
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.left, currentLevel + 1));
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.right, currentLevel + 1));
                }
            } else {
                result.add(maxLevelValue);
                maxLevelValue = Integer.MIN_VALUE;
                currentLevel++;
            }
        }

        result.add(maxLevelValue);

        return result;
    }
}
