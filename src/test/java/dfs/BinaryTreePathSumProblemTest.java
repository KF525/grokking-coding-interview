package dfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePathSumProblemTest {

    BinaryTreePathSumProblem problem = new BinaryTreePathSumProblem();

    @Test
    void hasPathReturnsIfRootToLeafSums(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        assertTrue(problem.hasPath(root,23));
        assertFalse(problem.hasPath(root,16));
    }
}