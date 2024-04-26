package graphs;

import java.util.*;

public class AdjacencyListWeightedDigraph implements IWeightedDigraph {
    private List<Node>[] adjacencyList;

    public AdjacencyListWeightedDigraph(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        this.adjacencyList = (LinkedList<Node>[]) new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    @Override
    public int edgeCount() {
        int edges = 0;

        for (List<Node> list : adjacencyList) {
            edges += list.size();
        }
        return edges;
    }

    @Override
    public int vertexCount() {
        return adjacencyList.length;
    }

    @Override
    public boolean addEdge(int u, int v, double w) {
        if (!hasEdge(u, v)) {
            adjacencyList[u].add(new Node(v, w));
            return true;
        }

        return false;
    }

    @Override
    public boolean addEdgeU(int u, int v, double w) {
        if (!hasEdge(u, v) && !hasEdge(v, u)) {
            addEdge(u, v, w);
            addEdge(v, u, w);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdge(int u, int v) {
        Node node = getNode(u, v);
        Node reversedNode = getNode(v, u);

        if (reversedNode == null || reversedNode.weight != node.weight) {
            return adjacencyList[u].remove(node);
        }
        return false;
    }

    @Override
    public boolean removeEdgeU(int u, int v) {
        Node firstNode = getNode(u, v);
        Node secondNode = getNode(v, u);

        if (firstNode != null && secondNode != null && firstNode.weight == secondNode.weight) {
            adjacencyList[u].remove(firstNode);
            adjacencyList[v].remove(secondNode);
            return true;
        }
        return false;
    }

    @Override
    public boolean hasEdge(int u, int v) {
        return getNode(u, v) != null;
    }

    @Override
    public boolean hasEdgeU(int u, int v) {
        Node firstNode = getNode(u, v);
        Node secondNode = getNode(v, u);

        return firstNode != null && secondNode != null && firstNode.weight == secondNode.weight;
    }

    @Override
    public List<Integer> verticesConnectedTo(int v) {
        List<Integer> vertices = new ArrayList<>();

        for (Node node : adjacencyList[v]) {
            vertices.add(node.vertex);
        }

        return vertices;
    }

    @Override
    public double weight(int u, int v) {
        Node node = getNode(u, v);

        if (node != null) {
            return node.weight;
        }
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public void weight(int u, int v, double w) {
        Node node = getNode(u, v);
        Node reversedNode = getNode(v, u);

        if (node != null && (reversedNode == null || reversedNode.weight != node.weight)) {
            node.weight = w;
        }
    }

    @Override
    public Iterator<WeightedEdge> edges(int v) {
        return new AdjacencyListWeightedDigraphIterator(v);
    }

    private Node getNode(int u, int v) {
        if (u >= vertexCount() || v >= vertexCount() || u < 0 || v < 0) {
            throw new IllegalArgumentException();
        }

        for (ListIterator<Node> itr = adjacencyList[u].listIterator(); itr.hasNext(); ) {
            Node node = itr.next();

            if (node.vertex == v) {
                return node;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < adjacencyList.length; i++) {
            buffer.append("Vertex ").append(i).append(": ").append(adjacencyList[i]);
            buffer.append("\n");
        }
        buffer.setLength(buffer.length() - 1);

        return buffer.toString();
    }

    private class Node {
        private int vertex;
        private double weight;

        public Node(int vertex) {
            this.vertex = vertex;
        }

        public Node(int vertex, double weight) {
            this(vertex);
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(v: " + vertex + ", w: " + weight + ")";
        }
    }

    private class AdjacencyListWeightedDigraphIterator implements Iterator<WeightedEdge> {
        private Iterator<Node> innerIterator;
        private int vertex;

        public AdjacencyListWeightedDigraphIterator(int v) {
            this.innerIterator = adjacencyList[v].listIterator();
            this.vertex = v;
        }

        @Override
        public boolean hasNext() {
            return innerIterator.hasNext();
        }

        @Override
        public WeightedEdge next() {
            Node node = innerIterator.next();

            return new WeightedEdge(vertex, node.vertex, node.weight);
        }
    }
}
