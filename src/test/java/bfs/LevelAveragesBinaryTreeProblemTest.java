package bfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelAveragesBinaryTreeProblemTest {

    LevelAveragesBinaryTreeProblem problem = new LevelAveragesBinaryTreeProblem();

    @Test
    void findLevelAveragesReturnsListOfAverages() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<Double> result = problem.findLevelAverages(root);
        assertEquals(3, result.size());
        assertEquals(12.0, result.get(0));
        assertEquals(4.0, result.get(1));
        assertEquals(6.5, result.get(2));
    }
}