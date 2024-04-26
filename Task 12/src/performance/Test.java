package performance;

import algorithms.Kruskal;
import algorithms.MST_Algorithm;
import algorithms.Prime;
import converting.Converter;
import graphs.AdjacencyListWeightedDigraph;
import graphs.AdjacencyMatrixWeightedDigraph;
import graphs.IWeightedDigraph;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Generator generator = new MatrixGraphGenerator();
        PerformanceTester tester = new PerformanceTester(new Kruskal());
        int[] vertices = {100, 250, 500, 1000, 2500, 5000, 7500, 10000};
        int[] edges = {5, 10, 15, 20, 25, 30, 35, 40};
        List<IWeightedDigraph> matrixGraphs = new ArrayList<>();
        List<IWeightedDigraph> listGraphs = new ArrayList<>();
        Converter converter = new Converter();

        for (int size : vertices){
            matrixGraphs.add(generator.generate(size, 30, 1000));
        }

        System.out.println("\nVertices, Matrix, Kruskal:\n");
        for (IWeightedDigraph graph : matrixGraphs){
            System.out.println(tester.testPerformance(graph));
        }

        tester = new PerformanceTester(new Prime());

        System.out.println("\nVertices, Matrix, Prime:\n");
        for (IWeightedDigraph graph : matrixGraphs){
            System.out.println(tester.testPerformance(graph));
        }


        for (IWeightedDigraph graph : matrixGraphs){
            listGraphs.add(converter.convert((AdjacencyMatrixWeightedDigraph) graph));
        }

        tester = new PerformanceTester(new Kruskal());

        System.out.println("\nVertices, List, Kruskal:\n");
        for (IWeightedDigraph graph : listGraphs){
            System.out.println(tester.testPerformance(graph));
        }

        tester = new PerformanceTester(new Prime());

        System.out.println("\nVertices, List, Prime:\n");
        for (IWeightedDigraph graph : listGraphs){
            System.out.println(tester.testPerformance(graph));
        }

        ///////////////////////////////////////////////////////////////////////////////////////
        matrixGraphs.clear();
        listGraphs.clear();


        for (int size : edges){
            matrixGraphs.add(generator.generate(5000, size, 1000));
        }

        System.out.println("\nEdges, Matrix, Kruskal:\n");
        for (IWeightedDigraph graph : matrixGraphs){
            System.out.println(tester.testPerformance(graph));
        }

        tester = new PerformanceTester(new Prime());

        System.out.println("\nEdges, Matrix, Prime:\n");
        for (IWeightedDigraph graph : matrixGraphs){
            System.out.println(tester.testPerformance(graph));
        }


        for (IWeightedDigraph graph : matrixGraphs){
            listGraphs.add(converter.convert((AdjacencyMatrixWeightedDigraph) graph));
        }

        tester = new PerformanceTester(new Kruskal());

        System.out.println("\nEdges, List, Kruskal:\n");
        for (IWeightedDigraph graph : listGraphs){
            System.out.println(tester.testPerformance(graph));
        }

        tester = new PerformanceTester(new Prime());

        System.out.println("\nEdges, List, Prime:\n");
        for (IWeightedDigraph graph : listGraphs){
            System.out.println(tester.testPerformance(graph));
        }

    }
}
