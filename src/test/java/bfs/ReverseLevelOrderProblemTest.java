package bfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLevelOrderProblemTest {

    ReverseLevelOrderProblem problem = new ReverseLevelOrderProblem();

    @Test
    void traverseReturnsNodeListByLevel() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<List<Integer>> traverse = problem.traverse(root);
        assertEquals(3, traverse.size());
        assertEquals(9, traverse.get(0).get(0));
        assertEquals(10, traverse.get(0).get(1));
        assertEquals(5, traverse.get(0).get(2));
        assertEquals(7, traverse.get(1).get(0));
        assertEquals(1, traverse.get(1).get(1));
        assertEquals(12, traverse.get(2).get(0));
    }
}