package bfs;

import bfs.util.TreeNodeWithPointer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectLevelOrderSiblingsProblemTest {

    ConnectLevelOrderSiblingsProblem problem = new ConnectLevelOrderSiblingsProblem();

    @Test
    void connectNodesPointToTheirSiblings() {
        TreeNodeWithPointer root = new TreeNodeWithPointer(12);
        root.left = new TreeNodeWithPointer(7);
        root.right = new TreeNodeWithPointer(1);
        root.left.left = new TreeNodeWithPointer(9);
        root.right.left = new TreeNodeWithPointer(10);
        root.right.right = new TreeNodeWithPointer(5);
        problem.connect(root);
        printLevelOrder(root);
    }

    void printLevelOrder(TreeNodeWithPointer root) {
        TreeNodeWithPointer nextLevelRoot = root;
        while (nextLevelRoot != null) {
            TreeNodeWithPointer current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}