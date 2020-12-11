package com.letsdoguru;

import com.letsdoguru.tree.BinaryTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<>(((o1, o2) -> o1.compareTo(o2)));
        Arrays.asList(6, 4, 5, 3, 8, 9, 7).forEach(tree::addNode);
        tree.findNode(4);


        System.in.read();
    }
}
