package graphs;

import java.util.Objects;

public class UndirectedWeightedEdge {
    public final int beginning;
    public final int end;
    public final double weight;

    public UndirectedWeightedEdge(int beginning, int end, double weight) {
        this.beginning = beginning;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + beginning + ", " + end + ", " + weight + ")";
    }


}
