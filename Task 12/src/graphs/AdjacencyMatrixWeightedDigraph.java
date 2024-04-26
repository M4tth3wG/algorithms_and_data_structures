package graphs;

import java.util.*;

public class AdjacencyMatrixWeightedDigraph implements IWeightedDigraph{
    private double[][] adjacencyMatrix;

    public AdjacencyMatrixWeightedDigraph(int n) {
        if (n <= 0){
            throw new IllegalArgumentException();
        }

        this.adjacencyMatrix = new double[n][n];

        for (int i = 0; i < n; i++){
            Arrays.fill(adjacencyMatrix[i], Double.POSITIVE_INFINITY);
        }
    }

    @Override
    public int edgeCount() {
        int edges = 0;

        for (int u = 0; u < vertexCount(); u++){
            for (int v = 0; v < vertexCount(); v++){
                if (hasEdge(u, v)){
                    edges++;
                }
            }
        }
        return edges;
    }

    @Override
    public int vertexCount() {
        return adjacencyMatrix.length;
    }

    @Override
    public boolean addEdge(int u, int v, double w) {
        if (!hasEdge(u, v)){
            adjacencyMatrix[u][v] = w;
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdgeU(int u, int v, double w) {
        if (!hasEdge(u, v) && !hasEdge(v, u)){
            adjacencyMatrix[u][v] = w;
            adjacencyMatrix[v][u] = w;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdge(int u, int v) {
        if (hasEdge(u, v) && !hasEdgeU(u, v)){
            adjacencyMatrix[u][v] = Double.POSITIVE_INFINITY;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdgeU(int u, int v) {
        if (hasEdgeU(u, v)){
            adjacencyMatrix[u][v] = Double.POSITIVE_INFINITY;
            adjacencyMatrix[v][u] = Double.POSITIVE_INFINITY;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasEdge(int u, int v) {
        return weight(u, v) != Double.POSITIVE_INFINITY;
    }

    @Override
    public boolean hasEdgeU(int u, int v) {
        return hasEdge(u, v) && hasEdge(v, u) && weight(u, v) == weight(v, u);
    }

    @Override
    public List<Integer> verticesConnectedTo(int v) {
        List<Integer> vertices = new ArrayList<>();

        for (int u = 0; u < adjacencyMatrix.length; u++){
            if (hasEdge(v, u)){
                vertices.add(u);
            }
        }
        return vertices;
    }

    @Override
    public double weight(int u, int v) {
        if (u >= vertexCount() || v >= vertexCount() || u < 0 || v < 0){
            throw new IllegalArgumentException();
        }
        return adjacencyMatrix[u][v];
    }

    @Override
    public void weight(int u, int v, double w) {
        if (hasEdge(u, v) && !hasEdgeU(u, v)){
            adjacencyMatrix[u][v] = w;
        }
    }

    @Override
    public Iterator<WeightedEdge> edges(int v) {
        return new AdjacencyMatrixWeightedDigraphIterator(v);
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        Formatter fm = new Formatter(buffer);

        fm.format("%3s", "");

        for (int j = 0; j < adjacencyMatrix.length; j++){
            fm.format("%15d", j);
        }
        buffer.append("\n");

        for (int i = 0; i < adjacencyMatrix.length; i++){
            fm.format("%3d", i);

            for (double weight : adjacencyMatrix[i]){
                fm.format("%15.3f", weight);
            }
            buffer.append("\n");
        }
        buffer.setLength(buffer.length() - 1);

        return buffer.toString();
    }

    private class AdjacencyMatrixWeightedDigraphIterator implements Iterator<WeightedEdge> {

        private int vertex;
        private int currentPos;

        public AdjacencyMatrixWeightedDigraphIterator(int v) {
            this.vertex = v;
            this.currentPos = -1;
        }

        @Override
        public boolean hasNext() {
            return findNext() < adjacencyMatrix[vertex].length;
        }

        @Override
        public WeightedEdge next() {
            int nextPos = findNext();
            currentPos = nextPos;

            return new WeightedEdge(vertex, nextPos, adjacencyMatrix[vertex][nextPos]);
        }

        private int findNext() {
            int nextPos = currentPos + 1;

            for (; nextPos < adjacencyMatrix[vertex].length && adjacencyMatrix[vertex][nextPos] == Double.POSITIVE_INFINITY; ++nextPos) {
            }

            return nextPos;
        }
    }
}
