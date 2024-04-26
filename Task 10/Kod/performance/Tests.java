package performance;

import disjointSets.ForestDisjointSet;
import disjointSets.ListDisjointSet;

public class Tests {
    public static void main(String[] args) {
        PerformanceTester<ListDisjointSet> ptList = new ListDisjointSetPerformanceTester(new Timer(), new ListDisjointSetGenerator());
        PerformanceTester<ForestDisjointSet> ptForest = new ForestDisjointPerformanceTester(new Timer(), new ForestDisjointSetGenerator());
        int[] sizes = {1000000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000, 9000000, 10000000, 11000000, 12000000, 13000000, 14000000, 15000000, 16000000, 17000000, 18000000, 19000000, 20000000, 21000000, 22000000, 23000000, 24000000, 25000000};
        StringBuffer[] buffers = new StringBuffer[6];

        for (int i = 0; i < buffers.length; i++){
            buffers[i] = new StringBuffer();
        }


        for (int size : sizes){
            buffers[0].append(ptList.joiningSetsTest(size)).append("\n");
            buffers[1].append(ptList.findingSetTest(size)).append("\n");
            buffers[2].append(ptList.checkingIfDisjointTest(size)).append("\n");

            buffers[3].append(ptForest.joiningSetsTest(size)).append("\n");
            buffers[4].append(ptForest.findingSetTest(size)).append("\n");
            buffers[5].append(ptForest.checkingIfDisjointTest(size)).append("\n");
        }

        System.out.println("JoiningTest List:\n" + buffers[0]);
        System.out.println("FindingTest List:\n" + buffers[1]);
        System.out.println("CheckingIfDisjoint List:\n" + buffers[2]);

        System.out.println("JoiningTest Forest:\n" + buffers[3]);
        System.out.println("FindingTest Forest:\n" + buffers[4]);
        System.out.println("CheckingIfDisjoint Forest:\n" + buffers[5]);
    }
}
