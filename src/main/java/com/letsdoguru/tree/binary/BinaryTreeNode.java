package com.letsdoguru.tree.binary;

public class BinaryTreeNode<T> {
    private T value;
    private BinaryTreeNode<T> leftTree;
    private BinaryTreeNode<T> rightTree;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(BinaryTreeNode<T> leftTree) {
        this.leftTree = leftTree;
    }

    public BinaryTreeNode<T> getRightTree() {
        return rightTree;
    }

    public void setRightTree(BinaryTreeNode<T> rightTree) {
        this.rightTree = rightTree;
    }
}
