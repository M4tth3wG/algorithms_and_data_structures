import algorithms.Kruskal;
import algorithms.MST_Algorithm;
import algorithms.Prime;
import graphs.AdjacencyListWeightedDigraph;
import graphs.AdjacencyMatrixWeightedDigraph;
import graphs.IWeightedDigraph;
import loaders.ListGraphLoader;
import loaders.MalformedGraphDescriptionException;
import loaders.MatrixGraphLoader;

public class Main {
    public static void main(String[] args) throws MalformedGraphDescriptionException {
        MST_Algorithm kruskal = new Kruskal();
        MST_Algorithm prime = new Prime();

        IWeightedDigraph graph = ListGraphLoader.loadUndirectedGraph("src/graph1.txt");
//        System.out.println("\nStarting graph:\n");
//        System.out.println(graph);
//        System.out.println("\nKruskal:");
//        System.out.println(kruskal.generateMST(graph));
//        System.out.println("\nPrime:");
//        System.out.println(prime.generateMST(graph));
//
//
//        graph = MatrixGraphLoader.loadUndirectedGraph("src/graph1.txt");
//        System.out.println("\nStarting graph:\n");
//        System.out.println(graph);
//        System.out.println("\nKruskal:");
//        System.out.println(kruskal.generateMST(graph));
//        System.out.println("\nPrime:");
//        System.out.println(prime.generateMST(graph));


//        graph = ListGraphLoader.loadUndirectedGraph("src/graph2.txt");
//        System.out.println("\nStarting graph:\n");
//        System.out.println(graph);
//        System.out.println("\nKruskal:");
//        System.out.println(kruskal.generateMST(graph));
//        System.out.println("\nPrime:");
//        System.out.println(prime.generateMST(graph));


        graph = MatrixGraphLoader.loadUndirectedGraph("src/graph2.txt");
        System.out.println("\nStarting graph:\n");
        System.out.println(graph);
        System.out.println("\nKruskal:");
        System.out.println(kruskal.generateMST(graph));
        System.out.println("\nPrime:");
        System.out.println(prime.generateMST(graph));


//        graph = ListGraphLoader.loadUndirectedGraph("src/emptyGraph.txt");
//        System.out.println("\nStarting graph:\n");
//        System.out.println(graph);
//        System.out.println("\nKruskal:");
//        System.out.println(kruskal.generateMST(graph));
//        System.out.println("\nPrime:");
//        System.out.println(prime.generateMST(graph));
//
//
//        graph = MatrixGraphLoader.loadUndirectedGraph("src/emptyGraph.txt");
//        System.out.println("\nStarting graph:\n");
//        System.out.println(graph);
//        System.out.println("\nKruskal:");
//        System.out.println(kruskal.generateMST(graph));
//        System.out.println("\nPrime:");
//        System.out.println(prime.generateMST(graph));
    }
}
