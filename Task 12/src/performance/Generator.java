package performance;

import graphs.IWeightedDigraph;

import java.util.List;

public interface Generator {
    IWeightedDigraph generate(int vertices, int edges, double weightBound);

}
