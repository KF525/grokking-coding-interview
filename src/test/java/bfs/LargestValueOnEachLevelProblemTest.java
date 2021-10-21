package bfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LargestValueOnEachLevelProblemTest {

    LargestValueOnEachLevelProblem problem = new LargestValueOnEachLevelProblem();

    @Test
    void getLargestLevelValuesReturnsListOfMaximums() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<Integer> result = problem.getLargestLevelValues(root);
        assertEquals(3, result.size());
        assertEquals(12, result.get(0));
        assertEquals(7, result.get(1));
        assertEquals(10, result.get(2));

        TreeNode root1 = new TreeNode(12);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(9);

        List<Integer> result1 = problem.getLargestLevelValues(root1);
        assertEquals(3, result1.size());
        assertEquals(12, result1.get(0));
        assertEquals(7, result1.get(1));
        assertEquals(9, result1.get(2));
    }
}