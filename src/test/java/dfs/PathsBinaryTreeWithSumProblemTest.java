package dfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathsBinaryTreeWithSumProblemTest {

    PathsBinaryTreeWithSumProblem problem = new PathsBinaryTreeWithSumProblem();

    @Test
    void findPathsReturnsAllValidPathsRootToLeaf() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> paths = problem.findPathsWithSum(root, sum);
        assertEquals(2, paths.size());
    }
}