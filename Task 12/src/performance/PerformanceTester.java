package performance;

import algorithms.MST_Algorithm;
import graphs.IWeightedDigraph;

public class PerformanceTester {
    private Timer timer;
    private MST_Algorithm mst_algorithm;


    public PerformanceTester(MST_Algorithm mst_algorithm) {
        this.timer = new Timer();
        this.mst_algorithm = mst_algorithm;

    }

    public long testPerformance(IWeightedDigraph graph){
        timer.reset();
        timer.start();

        mst_algorithm.generateMST(graph);

        timer.stop();

        return timer.getTimeInMillis();
    }
}
