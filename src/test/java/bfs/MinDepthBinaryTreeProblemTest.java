package bfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinDepthBinaryTreeProblemTest {

    MinDepthBinaryTreeProblem problem = new MinDepthBinaryTreeProblem();

    @Test
    void findDepthReturnsMinDepth() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        assertEquals(2, problem.findDepth(root));

        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        assertEquals(3, problem.findDepth(root));
    }


}