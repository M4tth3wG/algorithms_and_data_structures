package performance;

import graphs.AdjacencyMatrixWeightedDigraph;
import graphs.IWeightedDigraph;

import java.util.Random;

public class MatrixGraphGenerator implements Generator{
    private Random rng;

    public MatrixGraphGenerator() {
        this.rng = new Random();
    }

    @Override
    public IWeightedDigraph generate(int vertices, int edges, double weightBound) {
        IWeightedDigraph graph = new AdjacencyMatrixWeightedDigraph(vertices);

        while (edges > 0){
            if (graph.addEdgeU(rng.nextInt(vertices), rng.nextInt(vertices), rng.nextDouble(weightBound))){
                edges--;
            }
        }
        return graph;
    }
}
