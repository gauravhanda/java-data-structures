package com.letsdoguru.tree;

public interface Tree<T> {
    void addNode(T value);

    void print(BinaryTree.TraversalType traversalType);

    boolean isPresent(T t);

    enum TraversalType {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

}
