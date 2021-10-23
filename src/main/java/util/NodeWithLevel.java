package util;

public class NodeWithLevel {
    Node node;
    int level;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public NodeWithLevel(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}