package dfs;

import bfs.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathsBinaryTreeWithMaxProblem {
    public List<Integer> findPathsWithMax(TreeNode root) {
        List<Integer> maxPaths = new ArrayList<>();
        Integer currentMax = Integer.MIN_VALUE;
        allPathsMaxHelper(root, maxPaths, currentMax);
        return maxPaths;
    }
    void allPathsMaxHelper(TreeNode currentNode, List<Integer> maxPaths, Integer currentMax) {
        if (currentNode == null) return;
        Integer newMax = Math.max(currentMax, currentNode.val);
        if (currentNode.left == null && currentNode.right == null) {
            maxPaths.add(newMax);
        }
        allPathsMaxHelper(currentNode.left, maxPaths, newMax);
        allPathsMaxHelper(currentNode.right, maxPaths, newMax);
    }
}
