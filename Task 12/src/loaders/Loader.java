package loaders;

import graphs.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Loader {
    protected static int readNumberOfVertices(BufferedReader br) throws IOException, MalformedGraphDescriptionException {
        String input;
        String[] tokens;

        input = br.readLine();
        tokens = input.trim().split("\\s+");

        if (tokens.length != 1) {
            throw new MalformedGraphDescriptionException("Too many arguments in first line.");

        } else {

            try {
                return Integer.parseInt(tokens[0]);

            } catch (NumberFormatException e) {
                throw new MalformedGraphDescriptionException("Not an integer in first line.");

            } catch (IllegalArgumentException e) {
                throw new MalformedGraphDescriptionException("Incorrect number of vertices in first line.");
            }
        }
    }

    protected static void assembleDirectedGraph(BufferedReader br, IWeightedDigraph graph) throws IOException, MalformedGraphDescriptionException {
        String input;
        String[] tokens;

        for (int line = 2; (input = br.readLine()) != null && input.length() != 0; line++) {
            boolean isUndirected = false;
            boolean alreadyExists;
            int u;
            int v;
            double weight;

            tokens = input.trim().split("\\s+");
            Iterator<String> itr = Arrays.stream(tokens).iterator();

            if (tokens.length != 3 && tokens.length != 4) {
                throw new MalformedGraphDescriptionException("Illegal number of arguments in line " + line + ".");
            } else if (tokens.length == 4) {
                if (itr.next().equals("u")) {
                    isUndirected = true;
                } else {
                    throw new MalformedGraphDescriptionException("Unexpected first character in line " + line + ".");
                }
            }

            try {
                u = Integer.parseInt(itr.next());
                v = Integer.parseInt(itr.next());
                weight = Double.parseDouble(itr.next());
            } catch (NumberFormatException e) {
                throw new MalformedGraphDescriptionException("At least one of the arguments in line " + line + " is an incorrect number.");
            }

            try {
                if (isUndirected) {
                    alreadyExists = !graph.addEdgeU(u, v, weight);
                } else {
                    alreadyExists = !graph.addEdge(u, v, weight);
                }
            } catch (IllegalArgumentException e) {
                throw new MalformedGraphDescriptionException("Incorrect argument in line " + line + ".");
            }

            if (alreadyExists) {
                throw new MalformedGraphDescriptionException("Edge described in line " + line + " already exists.");
            }
        }
    }

    protected static void assembleUndirectedGraph(BufferedReader br, IWeightedDigraph graph) throws IOException, MalformedGraphDescriptionException {
        String input;
        String[] tokens;

        for (int line = 2; (input = br.readLine()) != null && input.length() != 0; line++) {
            boolean alreadyExists;
            int u;
            int v;
            double weight;

            tokens = input.trim().split("\\s+");
            Iterator<String> itr = Arrays.stream(tokens).iterator();

            if (tokens.length != 3 && tokens.length != 4) {
                throw new MalformedGraphDescriptionException("Illegal number of arguments in line " + line + ".");
            } else if (tokens.length == 4 && !itr.next().equals("u")) {
                throw new MalformedGraphDescriptionException("Unexpected first character in line " + line + ".");
            }

            try {
                u = Integer.parseInt(itr.next());
                v = Integer.parseInt(itr.next());
                weight = Double.parseDouble(itr.next());
            } catch (NumberFormatException e) {
                throw new MalformedGraphDescriptionException("At least one of the arguments in line " + line + " is an incorrect number.");
            }

            try {
                alreadyExists = !graph.addEdgeU(u, v, weight);
            } catch (IllegalArgumentException e) {
                throw new MalformedGraphDescriptionException("Incorrect argument in line " + line + ".");
            }

            if (alreadyExists) {
                throw new MalformedGraphDescriptionException("Edge described in line " + line + " already exists.");
            }
        }
    }
}
