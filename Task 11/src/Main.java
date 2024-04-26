import converting.Converter;
import graphs.AdjacencyListWeightedDigraph;
import graphs.AdjacencyMatrixWeightedDigraph;
import graphs.IWeightedDigraph;
import graphs.WeightedEdge;
import loaders.ListGraphLoader;
import loaders.Loader;
import loaders.MalformedGraphDescriptionException;
import loaders.MatrixGraphLoader;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws MalformedGraphDescriptionException {
        Converter converter = new Converter();

        System.out.println("\n###################################################################\n");

        System.out.println("\nIWeightedDigraph graph = new AdjacencyListWeightedDigraph(5)");
        IWeightedDigraph graph = new AdjacencyListWeightedDigraph(5);

        System.out.println("\ngraph.addEdgeU(1, 2, 10): " + graph.addEdgeU(1, 2, 10));
        System.out.println("graph.addEdgeU(1, 2, 10): " + graph.addEdgeU(1, 2, 10));
        System.out.println("graph.addEdgeU(2, 1, 5): " + graph.addEdgeU(2, 1, 5));
        System.out.println("graph.addEdge(3, 4, 5): " + graph.addEdge(3, 4, 5));
        System.out.println("graph.addEdgeU(4, 3, 12): " + graph.addEdgeU(4, 3, 12));

        System.out.println("\ngraph.edgeCount(): " + graph.edgeCount());
        System.out.println("graph.verticesConnectedTo(3):" + graph.verticesConnectedTo(3));
        System.out.println("graph.weight(3, 4): " + graph.weight(3, 4));
        System.out.println("\ngraph.weight(3, 4, 10)");
        graph.weight(3, 4, 10);
        System.out.println("graph.weight(3, 4): " + graph.weight(3, 4));

        System.out.println("graph:\n" + graph);



        System.out.println("\n###################################################################\n");

        System.out.println("\ngraph = new AdjacencyMatrixWeightedDigraph(5)");
        graph = new AdjacencyMatrixWeightedDigraph(5);

        System.out.println("\ngraph.addEdgeU(1, 2, 10): " + graph.addEdgeU(1, 2, 10));
        System.out.println("graph.addEdgeU(1, 2, 10): " + graph.addEdgeU(1, 2, 10));
        System.out.println("graph.addEdgeU(2, 1, 5): " + graph.addEdgeU(2, 1, 5));
        System.out.println("graph.addEdge(3, 4, 5): " + graph.addEdge(3, 4, 5));
        System.out.println("graph.addEdgeU(4, 3, 12): " + graph.addEdgeU(4, 3, 12));

        System.out.println("\ngraph.edgeCount(): " + graph.edgeCount());
        System.out.println("graph.verticesConnectedTo(3):" + graph.verticesConnectedTo(3));
        System.out.println("graph.weight(3, 4): " + graph.weight(3, 4));
        System.out.println("\ngraph.weight(3, 4, 10)");
        graph.weight(3, 4, 10);
        System.out.println("graph.weight(3, 4): " + graph.weight(3, 4));

        System.out.println("graph:\n" + graph);


        System.out.println("\n###################################################################\n");

        System.out.println("\nLoading test: \n");
        graph = ListGraphLoader.loadDirectedGraph("C:\\Users\\matig\\IdeaProjects\\AiSD_Lab-lista_11\\src\\test.txt");
        System.out.println(graph);

        System.out.println("\nConversion test: \n");
        graph = converter.convert((AdjacencyListWeightedDigraph) graph);
        System.out.println(graph);

        System.out.println("\nIterator test:\n");
        System.out.println("MatrixDigraph:");
        Iterator<WeightedEdge> itr = graph.edges(4);

        while (itr.hasNext()){
            System.out.println("itr.next(): " + itr.next());
            System.out.println("itr.hasNext(): " + itr.hasNext());
        }

        graph = converter.convert((AdjacencyMatrixWeightedDigraph) graph);

        System.out.println("\nListDigraph:");
        itr = graph.edges(4);

        while (itr.hasNext()){
            System.out.println("itr.next(): " + itr.next());
            System.out.println("itr.hasNext(): " + itr.hasNext());
        }

    }
}
