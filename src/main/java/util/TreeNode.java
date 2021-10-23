package util;


public class TreeNode implements Node<TreeNode> {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public int getValue() {
        return this.val;
    }

    @Override
    public TreeNode getLeft() {
        return this.left;
    }

    @Override
    public TreeNode getRight() {
        return this.right;
    }

    @Override
    public void setValue(int val) {
        this.val = val;
    }

    @Override
    public void setLeft(TreeNode node) {
        this.left = node;
    }

    @Override
    public void setRight(TreeNode node) {
        this.right = node;
    }
}
