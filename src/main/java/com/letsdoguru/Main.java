package com.letsdoguru;

import com.letsdoguru.tree.BinaryTree;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<>(((o1, o2) -> o1.compareTo(o2)));
        Random random = new Random();
        Arrays.asList(41,12,40,6,100,1,0).forEach(tree::addNode);
        tree.print(BinaryTree.TraversalType.IN_ORDER);
    }
}
