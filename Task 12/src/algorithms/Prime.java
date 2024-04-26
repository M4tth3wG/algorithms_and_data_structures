package algorithms;

import graphs.AdjacencyMatrixWeightedDigraph;
import graphs.IWeightedDigraph;

import java.util.*;

public class Prime implements MST_Algorithm{
    @Override
    public IWeightedDigraph generateMST(IWeightedDigraph graph) {
        IWeightedDigraph mst = new AdjacencyMatrixWeightedDigraph(graph.vertexCount());
        Map<Integer, Integer> vertices = new HashMap<>();

        for (int v = 1; v < graph.vertexCount(); v++){
            vertices.put(v, v);
        }
        Map<Integer, Double> weights = generateWeightsMap(graph, vertices);

        while (!vertices.isEmpty()){
            Integer vertexWithMinimalWeight = null;
            double minimalWeight = Double.POSITIVE_INFINITY;

            for (int v : weights.keySet()){
                if (weights.get(v) < minimalWeight){
                    vertexWithMinimalWeight = v;
                    minimalWeight = weights.get(v);
                }
            }

            if (vertexWithMinimalWeight == null){
                break;
            }
            mst.addEdgeU(vertexWithMinimalWeight, vertices.get(vertexWithMinimalWeight), minimalWeight);

            weights.remove(vertexWithMinimalWeight);
            vertices.remove(vertexWithMinimalWeight);

            for (int v : vertices.keySet()){
                double newWeight = Math.min(weights.get(v), graph.weight(vertexWithMinimalWeight, v));

                if (newWeight != weights.get(v)) {
                    vertices.replace(v, vertexWithMinimalWeight);
                }
                weights.replace(v, newWeight);
            }
        }
        return mst;
    }

    private Map<Integer, Double> generateWeightsMap(IWeightedDigraph graph, Map<Integer, Integer> vertices){
        Map<Integer, Double> weights = new HashMap<>();

        for (int v : vertices.keySet()){
            if (graph.hasEdgeU(0, v)){
                weights.put(v, graph.weight(0, v));
                vertices.replace(v, 0);
            }
            else {
                weights.put(v, Double.POSITIVE_INFINITY);
            }
        }
        return weights;
    }
}
