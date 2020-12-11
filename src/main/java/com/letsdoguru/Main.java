package com.letsdoguru;

import com.letsdoguru.tree.BinaryTree;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<>(((o1, o2) -> o1.compareTo(o2)));
        Random random = new Random();
        IntStream.rangeClosed(1, 100000).map(random::nextInt).forEach(tree::addNode);
        tree.print(BinaryTree.TraversalType.IN_ORDER);
    }
}
