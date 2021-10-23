package dfs;

import bfs.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PathsBinaryTreeProblem {

    public List<List<Integer>> findAllPaths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        allPathsHelper(root, allPaths, currentPath);
        return allPaths;
    }

    public void allPathsHelper(TreeNode root, List<List<Integer>> allPaths, List<Integer> currentPath) {
        if (root == null) return;
        if (root.left == null && root.right == null){
            List<Integer> completedPath = new ArrayList<>(currentPath);
            allPaths.add(completedPath);
        }
        currentPath.add(root.val);
        allPathsHelper(root.left, allPaths, currentPath);
        allPathsHelper(root.right, allPaths, currentPath);
    }
}
