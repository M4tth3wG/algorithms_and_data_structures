package core;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T> implements Tree<T> {
    class Node<T> {
        T value; // element
        Node<T> left;
        Node<T> right;

        Node(T obj) {
            value = obj;
        }

        Node(T obj, Node<T> leftNode, Node<T> rightNode) {
            value = obj;
            left = leftNode;
            right = rightNode;
        }
    }

    private Comparator<T> comparator;
    private Node<T> root;
    private int size;

    public BinarySearchTree(Comparator<T> comp) {
        comparator = comp;
        root = null;
        size = 0;
    }


    public T find(T elem) {
        Node<T> node = search(elem);
        return node == null ? null : node.value;
    }

    private Node<T> search(T elem) {
        Node<T> node = root;
        int cmp = 0;
        while (node != null && (cmp = comparator.compare(elem, node.value)) != 0)
            node = cmp < 0 ? node.left : node.right;
        return node;
    }

    @Override
    public boolean add(T value) {
        try {
            root = insert(root, value);
        }
        catch (IllegalAccessError e){
            return false;
        }
        return true;
    }

    private Node<T> insert(Node<T> node, T elem) {
        if (node == null)
            node = new Node<T>(elem);
        else {
            int cmp = comparator.compare(elem, node.value);
            if (cmp < 0)
                node.left = insert(node.left, elem);
            else if (cmp > 0)
                node.right = insert(node.right, elem);
            else
                throw new IllegalArgumentException();
        }
        size++;
        return node;
    }

    @Override
    public boolean remove(T value) {
        try{
            root = delete(value, root);
        }
        catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    protected Node<T> delete(T elem, Node<T> node) {
        if (node == null) {
            throw new NoSuchElementException();
        } else {
            int cmp = comparator.compare(elem, node.value);
            if (cmp < 0)
                node.left = delete(elem, node.left);
            else if (cmp > 0)
                node.right = delete(elem, node.right);
            else if (node.left != null && node.right != null)
                node.right = detachMin(node, node.right);
            else node = (node.left != null) ? node.left : node.right;
        }
        size--;
        return node;
    }

    private Node<T> detachMin(Node<T> del, Node<T> node) {
        if (node.left != null) node.left = detachMin(del, node.left);
        else {
            del.value = node.value;
            node = node.right;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return find(value) != null;
    }

}
