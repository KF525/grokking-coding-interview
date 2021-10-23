package dfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathsBinaryTreeWithMaxProblemTest {

    PathsBinaryTreeWithMaxProblem problem = new PathsBinaryTreeWithMaxProblem();

    @Test
    void findPathsWithMaxReturnsMaxAllPaths() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<Integer> pathsWithMax = problem.findPathsWithMax(root);
        assertEquals(3, pathsWithMax.size());
        assertEquals(7, pathsWithMax.get(0));
        assertEquals(10, pathsWithMax.get(1));
        assertEquals(5, pathsWithMax.get(2));
    }
}