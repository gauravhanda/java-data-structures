package com.letsdoguru.tree;

import com.letsdoguru.tree.binary.BinaryTree;

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
