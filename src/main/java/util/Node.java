package util;

public interface Node<T extends Node> {
    int getValue();
    T getLeft();
    T getRight();
    void setValue(int val);
    void setLeft(T node);
    void setRight(T node);
}
