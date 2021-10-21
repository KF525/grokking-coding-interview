package bfs;

import bfs.util.NodeWithLevel;
import bfs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAveragesBinaryTreeProblem {

    public List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 1));
        int currentLevel = 1;
        double currentSum = 0.0;
        int currentSize = 0;

        while (!queue.isEmpty()) {
            if (queue.peek().level == currentLevel) {
                NodeWithLevel nodeWithLevel = queue.remove();
                currentSum = currentSum + nodeWithLevel.node.val;
                currentSize++;
                if (nodeWithLevel.node.left != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.left, currentLevel + 1));
                }
                if (nodeWithLevel.node.right != null) {
                    queue.add(new NodeWithLevel(nodeWithLevel.node.right, currentLevel + 1));
                }
            } else {
                currentLevel++;
                result.add(currentSum/currentSize);
                currentSum=0.0;
                currentSize=0;
            }
        }

        result.add(currentSum/currentSize);

        return result;
    }
}
