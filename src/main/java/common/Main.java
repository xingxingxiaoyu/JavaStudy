package common;

import java.util.ArrayList;

public class Main {

    private static BinaryTree<Integer> getPublicParent(BinaryTree<Integer> rootTree, BinaryTree<Integer> tree1, BinaryTree<Integer> tree2) {
        if (rootTree == tree1 || rootTree == tree2) {
            return rootTree;
        }

        if (tree1.getValue() <= rootTree.getValue() && tree2.getValue() <= rootTree.getValue()) {
            return getPublicParent(rootTree.left, tree1, tree2);
        } else if (tree1.getValue() > rootTree.getValue() && tree2.getValue() > rootTree.getValue()) {
            return getPublicParent(rootTree.right, tree1, tree2);
        } else {
            return rootTree;
        }
    }
}
