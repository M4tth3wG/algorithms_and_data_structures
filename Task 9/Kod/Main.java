import core.HeapyBinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HeapyBinarySearchTree<Integer> tree = new HeapyBinarySearchTree<>(Integer::compareTo);

        tree.add(5);
        tree.add(3);
        tree.add(10);

        System.out.println("contains(5): " + tree.contains(5));
        System.out.println("contains(2): " + tree.contains(2));
        System.out.println("size: " + tree.size());
        System.out.println("\nTree:\n" + tree);

        System.out.println("\nremove(2): " + tree.remove(2));
        System.out.println("size: " + tree.size());

        System.out.println("\nfind(5): " + tree.find(5));
        System.out.println("find(2): " + tree.find(2));

        System.out.println("\nremove(5): " + tree.remove(5));
        System.out.println("size: " + tree.size());
        System.out.println("contains(5): " + tree.contains(5));
        System.out.println("\nTree:\n" + tree);

    }
}
