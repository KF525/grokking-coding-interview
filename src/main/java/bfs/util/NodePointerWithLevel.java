package bfs.util;

public class NodePointerWithLevel {
    public TreeNodeWithPointer node;
    public int level;

    public NodePointerWithLevel(TreeNodeWithPointer node, int level) {
        this.node = node;
        this.level = level;
    }
}
