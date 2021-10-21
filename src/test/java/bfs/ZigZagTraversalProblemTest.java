package bfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagTraversalProblemTest {

    ZigZagTraversalProblem problem = new ZigZagTraversalProblem();

    @Test
    void traverseReturnsNodeListByLevelZigZag() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);

        List<List<Integer>> traverse = problem.traverse(root);
        assertEquals(4, traverse.size());
        assertEquals(12, traverse.get(0).get(0));
        assertEquals(1, traverse.get(1).get(0));
        assertEquals(7, traverse.get(1).get(1));
        assertEquals(9, traverse.get(2).get(0));
        assertEquals(10, traverse.get(2).get(1));
        assertEquals(5, traverse.get(2).get(2));
        assertEquals(17, traverse.get(3).get(0));
        assertEquals(20, traverse.get(3).get(1));
    }
}