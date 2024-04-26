package loaders;

import graphs.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ListGraphLoader extends Loader{

    public static AdjacencyListWeightedDigraph loadDirectedGraph(String path) throws MalformedGraphDescriptionException {
        AdjacencyListWeightedDigraph graph = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            int numberOfVertices = Loader.readNumberOfVertices(br);
            graph = new AdjacencyListWeightedDigraph(numberOfVertices);

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

    public static AdjacencyListWeightedDigraph loadUndirectedGraph(String path) throws MalformedGraphDescriptionException {
        AdjacencyListWeightedDigraph graph = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            int numberOfVertices = Loader.readNumberOfVertices(br);
            graph = new AdjacencyListWeightedDigraph(numberOfVertices);

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
