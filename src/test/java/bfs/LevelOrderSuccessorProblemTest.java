package bfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelOrderSuccessorProblemTest {

    LevelOrderSuccessorProblem problem = new LevelOrderSuccessorProblem();

    @Test
    void findSuccessorReturnsCorrectNode() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        TreeNode result = problem.findSuccessor(root, 12);
        assertEquals(root.left, result);

        TreeNode result1 = problem.findSuccessor(root, 9);
        assertEquals(root.right.left, result1);

        TreeNode result2 = problem.findSuccessor(root, 5);
        assertEquals(null, result2);
    }

    @Test
    void findSuccessor2ReturnsCorrectNode() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        TreeNode result = problem.findSuccessor2(root, 12);
        assertEquals(root.left, result);

        TreeNode result1 = problem.findSuccessor2(root, 9);
        assertEquals(root.right.left, result1);

        TreeNode result2 = problem.findSuccessor2(root, 5);
        assertEquals(null, result2);
    }
}