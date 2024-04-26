package converting;

import graphs.AdjacencyListWeightedDigraph;
import graphs.AdjacencyMatrixWeightedDigraph;

public class Converter {

    public AdjacencyListWeightedDigraph convert(AdjacencyMatrixWeightedDigraph graph){
        int vertices = graph.vertexCount();
        AdjacencyListWeightedDigraph returnGraph = new AdjacencyListWeightedDigraph(vertices);

        for (int u = 0; u < vertices; u++){
            for (int v : graph.verticesConnectedTo(u)){
                returnGraph.addEdge(u, v, graph.weight(u, v));
            }
        }

        return returnGraph;
    }

    public AdjacencyMatrixWeightedDigraph convert(AdjacencyListWeightedDigraph graph){
        int vertices = graph.vertexCount();
        AdjacencyMatrixWeightedDigraph returnGraph = new AdjacencyMatrixWeightedDigraph(vertices);

        for (int u = 0; u < vertices; u++){
            for (int v : graph.verticesConnectedTo(u)){
                returnGraph.addEdge(u, v, graph.weight(u, v));
            }
        }

        return returnGraph;
    }

}
