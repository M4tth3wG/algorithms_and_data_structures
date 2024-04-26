import java.util.*;

public class TreeHeap<T> implements Heap<T> {
    private Node<T> root;
    private int size = 0;
    private Comparator<T> comparator;

    public TreeHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        if (size == 0) {
            root = new Node(element);
            size++;
            return;
        }

        char[] directions = Integer.toBinaryString(size + 1).substring(1).toCharArray();

        Node<T> currentNode = root;
        Node<T> previousNode = root;
        T currentValue = element;
        T temporaryValue;

        for (int i = 0; i < directions.length; i++) {
            if (comparator.compare(currentNode.value, currentValue) > 0) {
                temporaryValue = currentNode.value;
                currentNode.setValue(currentValue);
                currentValue = temporaryValue;
            }

            int direction = Integer.parseInt(String.valueOf(directions[i]));
            previousNode = currentNode;

            if (direction == 1) {
                currentNode = currentNode.getRightChild();
            } else {
                currentNode = currentNode.getLeftChild();
            }
        }

        Node<T> leafNode = new Node<>(currentValue);
        int lastDirection = Integer.parseInt(String.valueOf(directions[directions.length - 1]));

        if (lastDirection == 1) {
            previousNode.setRightChild(leafNode);
        } else {
            previousNode.setLeftChild(leafNode);
        }

        size++;
    }

    @Override
    public T minimum() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T minimum = root.value;
        T replacementValue = root.value;

        Node<T> lastNodeParent = getNode((size - 2) / 2);

        if (lastNodeParent.rightChild != null){
            replacementValue = lastNodeParent.rightChild.value;
            lastNodeParent.setRightChild(null);
        }
        else if (lastNodeParent.leftChild != null){
            replacementValue = lastNodeParent.leftChild.value;
            lastNodeParent.setLeftChild(null);
        }

        root.setValue(replacementValue);

        size--;
        sink(root);

        return minimum;
    }

    private void sink(Node<T> start) {
        Node<T> current = start;
        Node<T> previous = start;
        Node<T> smallerNode = start.leftChild;

        if (smallerNode != null) {
            if (current.rightChild != null &&
                    comparator.compare(current.leftChild.value, current.rightChild.value) > 0)
                smallerNode = current.rightChild;

            if (comparator.compare(current.value, smallerNode.value) > 0) {
                swap(start, smallerNode);
                sink(smallerNode);
            }
        }
    }

    private void swap(Node<T> higher, Node<T> lower) {
        T tmp = higher.value;

        higher.setValue(lower.value);
        lower.setValue(tmp);
    }

    private Node<T> getNode(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentNode = root;
        char[] directions = Integer.toBinaryString(index + 1).substring(1).toCharArray();

        for (char direction : directions){
            int tmp = Integer.parseInt(String.valueOf(direction));

            if (tmp == 1) {
                currentNode = currentNode.getRightChild();
            } else {
                currentNode = currentNode.getLeftChild();
            }
        }

        return currentNode;
    }

    public String asOneLineString() {
        if (size == 0){
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("[ ");

        LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            buffer.append(current.value + ", ");

            if (current.leftChild != null) {
                queue.addLast(current.leftChild);
            }

            if (current.rightChild != null) {
                queue.addLast(current.rightChild);
            }
        }
        buffer.setLength(buffer.length() - 2);
        buffer.append(" ]");

        return buffer.toString();
    }

    @Override
    public String toString(){
        if (size == 0){
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        LinkedList<Node<T>> queue = new LinkedList<>();
        LinkedList<Node<T>> previousNodes = new LinkedList<>();

        queue.addLast(root);

        while (!queue.isEmpty()){
            previousNodes.clear();
            previousNodes.addAll(queue);
            queue.clear();

            for (Node<T> node : previousNodes){
                buffer.append(node.value).append(", ");

                if (node.leftChild != null){
                    queue.addLast(node.leftChild);
                }
                if (node.rightChild != null){
                    queue.addLast(node.rightChild);
                }
            }
            buffer.setLength(buffer.length() - 2);
            buffer.append("\n");
        }
        buffer.setLength(buffer.length() - 1);
        return buffer.toString();
    }

    public boolean isEmpty(){
        return size == 0;
    }


    private class Node<T> {
        protected T value;
        protected Node<T> leftChild;
        protected Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
