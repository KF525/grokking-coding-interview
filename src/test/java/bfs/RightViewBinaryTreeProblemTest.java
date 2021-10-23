package bfs;

import bfs.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RightViewBinaryTreeProblemTest {

    RightViewBinaryTreeProblem problem = new RightViewBinaryTreeProblem();

    @Test
    void traverseReturnsRightViewNodes() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);

        List<TreeNode> result = problem.traverse(root);
        assertEquals(4, result.size());
        assertEquals(root, result.get(0));
        assertEquals(root.right, result.get(1));
        assertEquals(root.right.right, result.get(2));
        assertEquals(root.left.left.left, result.get(3));
    }

}