package util;

public class TreeNodeWithPointer implements Node<TreeNodeWithPointer> {
    int val;
    TreeNodeWithPointer left;
    TreeNodeWithPointer right;
    TreeNodeWithPointer next;

    public TreeNodeWithPointer(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    @Override
    public int getValue() {
        return this.val;
    }

    public TreeNodeWithPointer getNext() {
        return next;
    }

    @Override
    public TreeNodeWithPointer getLeft() {
        return left;
    }

    @Override
    public TreeNodeWithPointer getRight() {
        return right;
    }

    @Override
    public void setValue(int val) {
        this.val = val;
    }

    @Override
    public void setLeft(TreeNodeWithPointer node) {
        this.left = node;
    }

    @Override
    public void setRight(TreeNodeWithPointer node) {
        this.right = node;
    }

    public TreeNodeWithPointer setNext(TreeNodeWithPointer next) {
        return this.next = next;
    }
}
