package algorithms;

import disjointSets.ForestDisjointSet;
import disjointSets.ListDisjointSet;
import graphs.*;


import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Kruskal implements MST_Algorithm{

    @Override
    public IWeightedDigraph generateMST(IWeightedDigraph graph) {
        IWeightedDigraph mst = new AdjacencyMatrixWeightedDigraph(graph.vertexCount());
        ForestDisjointSet[] verticesSets = new ForestDisjointSet[graph.vertexCount()];
        TreeSet<WeightedEdge> edgesSet = generateEdgesSet(graph);

        for (int i = 0; i < verticesSets.length; i++){
            verticesSets[i] = new ForestDisjointSet();
            verticesSets[i].makeSet();
        }

        while (!edgesSet.isEmpty()){
            WeightedEdge minimalEdge = edgesSet.pollFirst();
            int v = minimalEdge.beginning;
            int u = minimalEdge.end;
            double weight = minimalEdge.weight;

            if (verticesSets[v].isDisjoint(verticesSets[u])){
                mst.addEdgeU(v, u, weight);
                verticesSets[v].join(verticesSets[u]);
            }
        }
        return mst;
    }

    private TreeSet<WeightedEdge> generateEdgesSet(IWeightedDigraph graph){
        TreeSet<WeightedEdge> edgesSet = new TreeSet<>(new WeightedEdgeComparator());

        for (int v = 0; v < graph.vertexCount(); v++){
            List<Integer> connectedVertices = graph.verticesConnectedTo(v);

            for (int u : connectedVertices){
                //if (graph.hasEdgeU(v, u)){
                    edgesSet.add(new WeightedEdge(v, u, graph.weight(v, u)));
                //}
            }
        }
        return edgesSet;
    }
}
