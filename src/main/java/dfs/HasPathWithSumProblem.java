package dfs;

import bfs.util.TreeNode;

/**
 Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
 */
public class HasPathWithSumProblem {
    /**
     * Time complexity#
     *
     * The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.
     * Space complexity#
     *
     * The space complexity of the above algorithm will be O(N) in the worst case. This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child).
     */
    public boolean hasPath(TreeNode root, int sum) {
        if (root == null && sum == 0) return true;
        if (root == null) return false;
        if (sum < 0) return false;
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }
}
