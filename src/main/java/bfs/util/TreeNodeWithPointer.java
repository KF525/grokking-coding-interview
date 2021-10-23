package bfs.util;

public class TreeNodeWithPointer {
    public int val;
    public TreeNodeWithPointer left;
    public TreeNodeWithPointer right;
    public TreeNodeWithPointer next;

    public TreeNodeWithPointer(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
