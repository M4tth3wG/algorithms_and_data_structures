package core;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class HeapyBinarySearchTree<T> implements Tree<T> {
    private Comparator<T> comparator;
    private Node<T> root;
    private int size;
    private Random rng;

    public HeapyBinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
        this.rng = new Random();
    }

    @Override
    public boolean add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Heapy little accident! :)");
        }

        Node<T> node = new Node<>(value, Math.abs(rng.nextInt()));

        return addNode(node);
    }

    @Override
    public boolean remove(T value) {
        Node<T> parent;
        Node<T> node;

        try {
            parent = getParent(value);
        } catch (NoSuchElementException e) {
            return false;
        }

        if (parent == null) {
            node = root;
        } else if (comparator.compare(value, parent.value) < 0) {
            node = parent.leftChild;
        } else {
            node = parent.rightChild;
        }

        parent = toLeaf(node, parent);
        size--;

        if (parent == null) {
            return true;
        } else if (parent.leftChild == node) {
            parent.leftChild = null;
        } else {
            parent.rightChild = null;
        }

        return true;
    }

    private Node<T> toLeaf(Node<T> node, Node<T> parent){

        while (node.leftChild != null || node.rightChild != null) {
            Node<T> tmp;

            if (node.rightChild == null) {
                tmp = node.leftChild;
                rightRotation(node, parent);
            } else if (node.leftChild == null || node.leftChild.priority < node.rightChild.priority) {
                tmp = node.rightChild;
                leftRotation(node, parent);
            } else {
                tmp = node.leftChild;
                rightRotation(node, parent);
            }
            parent = tmp;

            if (root == node) {
                root = parent;
            }
        }
        return parent;

    }

    private Node<T> getParent(T value) throws NoSuchElementException {
        Node<T> parent = null;
        Node<T> child = root;
        int cmp;

        while ((cmp = comparator.compare(value, child.value)) != 0) {
            parent = child;

            if (cmp < 0) {
                child = child.leftChild;
            } else {
                child = child.rightChild;
            }

            if (child == null) {
                throw new NoSuchElementException();
            }
        }

        return parent;
    }

    @Override
    public T find(T value){
        Node<T> node;

        try{
            node = getParent(value);
        }
        catch (NoSuchElementException e){
            return null;
        }

        if (node == null){
            node = root;
        }
        else if (comparator.compare(value, node.value) < 0){
            node = node.leftChild;
        }
        else {
            node = node.rightChild;
        }

        return node.value;
    }

    private boolean addNode(Node<T> node) {
        if (size == 0) {
            root = node;
            size++;
            return true;
        }

        Node<T> previous;
        Node<T> child = root;
        LinkedList<Node<T>> heapPath = new LinkedList<>();

        while (child != null) {
            int cmp = comparator.compare(node.value, child.value);
            previous = child;
            heapPath.addFirst(previous);

            if (cmp > 0) {
                child = child.rightChild;

                if (child == null) {
                    previous.rightChild = node;
                }
            } else if (cmp < 0) {
                child = child.leftChild;

                if (child == null) {
                    previous.leftChild = node;
                }
            } else {
                return false;
            }
        }
        repairHeap(node, heapPath);
        size++;

        return true;
    }

    private void repairHeap(Node<T> node, LinkedList<Node<T>> heapPath) {
        Node<T> currentNode = heapPath.pollFirst();

        while (currentNode != null && node.priority > currentNode.priority) {
            if (currentNode.leftChild == node) {
                rightRotation(currentNode, heapPath.peek());
            } else {
                leftRotation(currentNode, heapPath.peek());
            }
            currentNode = heapPath.pollFirst();
        }
    }

    private void leftRotation(Node<T> node, Node<T> parent) {
        Node<T> tmp = node.rightChild;

        node.rightChild = tmp.leftChild;
        tmp.leftChild = node;

        if (parent == null) {
            root = tmp;
        } else if (comparator.compare(node.value, parent.value) < 0) {
            parent.leftChild = tmp;
        } else {
            parent.rightChild = tmp;
        }
    }

    private void rightRotation(Node<T> node, Node<T> parent) {
        Node<T> tmp = node.leftChild;

        node.leftChild = tmp.rightChild;
        tmp.rightChild = node;

        if (parent == null) {
            root = tmp;
        } else if (comparator.compare(node.value, parent.value) < 0) {
            parent.leftChild = tmp;
        } else {
            parent.rightChild = tmp;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        Node<T> currentNode = root;

        while (currentNode != null) {
            int cmp = comparator.compare(value, currentNode.value);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }

        }

        return false;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        LinkedList<Node<T>> queue = new LinkedList<>();
        LinkedList<Node<T>> previousNodes = new LinkedList<>();

        queue.addLast(root);

        for (int i = 0; i < size; ) {
            previousNodes.clear();
            previousNodes.addAll(queue);
            queue.clear();

            for (Node<T> node : previousNodes) {

                if (node != null) {
                    buffer.append("Node{ value: ").append(node.value).append(", priority: ").append(node.priority).append(" }; ");
                    i++;

                    if (node.leftChild != null) {
                        queue.addLast(node.leftChild);
                    } else {
                        queue.addLast(null);
                    }

                    if (node.rightChild != null) {
                        queue.addLast(node.rightChild);
                    } else {
                        queue.addLast(null);
                    }
                } else {
                    buffer.append("---").append("; ");

                    queue.addLast(null);
                    queue.addLast(null);
                }


            }
            buffer.setLength(buffer.length() - 2);
            buffer.append("\n");
        }
        buffer.setLength(buffer.length() - 1);
        return buffer.toString();
    }

    private class Node<T> {
        private T value;
        private int priority;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public Node(T value, int priority, Node<T> leftChild, Node<T> rightChild) {
            this(value, priority);
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
