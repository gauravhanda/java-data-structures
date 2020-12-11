package com.letsdoguru.tree;

import java.util.Comparator;

/**
 * Tree with traversal of order O(N) and search time of log(N)
 *
 * @param <T>
 */
public class BinaryTree<T> {
    private BinaryTreeNode<T> rootNode;
    private Comparator<T> comparator;
    private int traverseCount;
    int treeSize = 0;

    public enum TraversalType {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void addNode(T value) {
        BinaryTreeNode<T> newNode = insertNode(rootNode, value);
        if (rootNode == null) {
            rootNode = newNode;
        }
        treeSize++;
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

    public void print(TraversalType traversalType) {
        traverseCount = 0;
        switch (traversalType) {
            case PRE_ORDER:
                preOrderTraverse(rootNode);
                break;
            case POST_ORDER:
                postOrderTraverse(rootNode);
                break;
            default:
                inOrderTraverse(rootNode);
                System.out.println("Method called " + traverseCount);
                break;
        }
    }

    /**
     * Putting hte null check is important as it cuts the number iterations by half. The number of iterates done are
     * equal to the number of nodes created. As recursion demands local method stack to un-wind, its wise to
     * avoid those in-effective calls.
     *
     * @param node
     */
    public void inOrderTraverse(BinaryTreeNode<T> node) {
        traverseCount++;
        if (node != null) {
            if (node.getLeftTree() != null) {
                inOrderTraverse(node.getLeftTree());
            }
            System.out.println("-> " + node.getValue());
            if (node.getRightTree() != null) {
                inOrderTraverse(node.getRightTree());
            }
        }
    }


    public void preOrderTraverse(BinaryTreeNode<T> node) {
        System.out.println("-> " + node.getValue());
        if (node != null) {
            if (node.getLeftTree() != null) {
                preOrderTraverse(node.getLeftTree());
            }
            if (node.getRightTree() != null) {
                preOrderTraverse(node.getRightTree());
            }
        }
    }

    public void postOrderTraverse(BinaryTreeNode<T> node) {
        if (node != null) {
            if (node.getLeftTree() != null) {
                postOrderTraverse(node.getLeftTree());
            }
            if (node.getRightTree() != null) {
                postOrderTraverse(node.getRightTree());
            }
            System.out.println("-> " + node.getValue());
        }
    }

    /**
     * Iterates to find if the value is present
     *
     * @param t
     * @return
     */
    public boolean isPresent(T t) {
        traverseCount = 0;
        boolean status =  searchTree(rootNode, t);
        System.out.println("Actual search count " + traverseCount + " Expected search iterations = log(n) "
                + Math.log(treeSize)/Math.log(2));

        return status;

    }

    private boolean searchTree(BinaryTreeNode<T> node, T value) {
        traverseCount++;
        boolean matchFound = false;

        if (node != null) {
            int comparison = comparator.compare(value, node.getValue());
            matchFound = comparison == 0;

            if (comparison == 1 && node.getRightTree() != null) {
                matchFound = searchTree(node.getRightTree(), value);
            } else if (comparison == -1 && node.getLeftTree() != null) {
                matchFound = searchTree(node.getLeftTree(), value);
            }
        }

        return matchFound;
    }
}
