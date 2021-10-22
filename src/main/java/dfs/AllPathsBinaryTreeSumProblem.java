package dfs;

import bfs.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */
public class AllPathsBinaryTreeSumProblem {

    public List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        allPathsHelper(root, sum, allPaths, currentPath);
        return allPaths;
    }

    public void allPathsHelper(TreeNode currentNode, int sum, List<List<Integer>> allPaths,
                               List<Integer> currentPath) {
        if (currentNode == null) return;
        currentPath.add(currentNode.val);

        if (currentNode.left == null && currentNode.right == null && sum == currentNode.val) {
            //create a new list with that path
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            allPathsHelper(currentNode.left, sum - currentNode.val, allPaths, currentPath);
            allPathsHelper(currentNode.right, sum - currentNode.val, allPaths, currentPath);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }
}
