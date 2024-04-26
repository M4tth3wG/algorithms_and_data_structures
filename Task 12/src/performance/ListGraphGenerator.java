package performance;

import graphs.AdjacencyListWeightedDigraph;
import graphs.AdjacencyMatrixWeightedDigraph;
import graphs.IWeightedDigraph;

import java.util.Random;

public class ListGraphGenerator implements Generator{
    private Random rng;

    public ListGraphGenerator() {
        this.rng = new Random();
    }

    @Override
    public IWeightedDigraph generate(int vertices, int edges, double weightBound) {
        IWeightedDigraph graph = new AdjacencyListWeightedDigraph(vertices);

        while (edges > 0){
            if (graph.addEdgeU(rng.nextInt(vertices), rng.nextInt(vertices), rng.nextDouble(weightBound))){
                edges--;
            }
        }
        return graph;
    }
}
