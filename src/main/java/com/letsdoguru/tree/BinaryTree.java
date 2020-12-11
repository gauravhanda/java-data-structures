package com.letsdoguru.tree;

import java.util.Comparator;

public class BinaryTree<T> {
    private BinaryTreeNode<T> rootNode;
    private Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void addNode(T value) {
        BinaryTreeNode<T> newNode = insertNode(rootNode, value);

        if (rootNode == null) {
            rootNode = newNode;
        }

    }

    private BinaryTreeNode<T> insertNode(BinaryTreeNode<T> node, T value) {
        if (node != null) {
            int comparison = comparator.compare(value, node.getValue());

            if (comparison <= 0) {
                node.setLeftTree(insertNode(node.getLeftTree(), value));
            } else {
                node.setRightTree(insertNode(node.getRightTree(), value));
            }
        } else {
            node = createNode(value, null, null);
        }
        return node;
    }

    private BinaryTreeNode<T> createNode(T value, BinaryTreeNode<T> leftNode, BinaryTreeNode<T> rightNode) {
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(value);
        newNode.setLeftTree(leftNode);
        newNode.setRightTree(rightNode);
        return newNode;
    }

    public void findNode(T t) {
        System.out.println(rootNode);
    }
}
