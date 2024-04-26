package loaders;

import graphs.AdjacencyMatrixWeightedDigraph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class MatrixGraphLoader extends Loader{

    public static AdjacencyMatrixWeightedDigraph loadDirectedGraph(String path) throws MalformedGraphDescriptionException {
        AdjacencyMatrixWeightedDigraph graph = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            int numberOfVertices = Loader.readNumberOfVertices(br);
            graph = new AdjacencyMatrixWeightedDigraph(numberOfVertices);

            Loader.assembleDirectedGraph(br, graph);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            throw new MalformedGraphDescriptionException("The file is empty.");
        } catch (IllegalArgumentException e){
            throw new MalformedGraphDescriptionException("Incorrect number of vertices in first line.");
        }

        return graph;
    }

    public static AdjacencyMatrixWeightedDigraph loadUndirectedGraph(String path) throws MalformedGraphDescriptionException {
        AdjacencyMatrixWeightedDigraph graph = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            int numberOfVertices = Loader.readNumberOfVertices(br);
            graph = new AdjacencyMatrixWeightedDigraph(numberOfVertices);

            Loader.assembleUndirectedGraph(br, graph);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            throw new MalformedGraphDescriptionException("The file is empty.");
        } catch (IllegalArgumentException e){
            throw new MalformedGraphDescriptionException("Incorrect number of vertices in first line.");
        }

        return graph;
    }
}
