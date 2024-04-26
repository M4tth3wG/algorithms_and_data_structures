package graphs;

public class WeightedEdge {
    public final int beginning;
    public final int end;
    public final double weight;

    public WeightedEdge(int beginning, int end, double weight)
    {
        this.beginning = beginning;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "(" + beginning + ", " + end + ", " + weight + ")";
    }

}
