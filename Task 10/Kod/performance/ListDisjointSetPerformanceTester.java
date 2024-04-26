package performance;

import disjointSets.DisjointSet;
import disjointSets.ListDisjointSet;

import java.util.List;

public class ListDisjointSetPerformanceTester extends PerformanceTester<ListDisjointSet> {

    public ListDisjointSetPerformanceTester(Timer timer, Generator<ListDisjointSet> generator) {
        super(timer, generator);
    }

    @Override
    public long joiningSetsTest(int size) {
        List<ListDisjointSet> setList = generator.generate(size);
        ListDisjointSet firsSet = setList.get(0);

        timer.reset();
        timer.start();

        for (ListDisjointSet set : setList){
            firsSet.join(set);
            firsSet = set;
        }

        timer.stop();

        return timer.getTimeInMillis();
    }

    @Override
    public long findingSetTest(int size) {
        List<ListDisjointSet> setList = generator.generate(size);
        ListDisjointSet firsSet = setList.remove(0);
        ListDisjointSet lastSet = null;

        for (ListDisjointSet set : setList){
            firsSet.join(set);
            lastSet = set;
        }

        timer.reset();
        timer.start();

        for (ListDisjointSet set : setList){
            set.findSet();
        }

        timer.stop();

        return timer.getTimeInMillis();
    }

    @Override
    public long checkingIfDisjointTest(int size) {
        List<ListDisjointSet> setList = generator.generate(size);
        ListDisjointSet firsSet = setList.remove(0);
        ListDisjointSet lastSet = null;

        for (ListDisjointSet set : setList){
            firsSet.join(set);
            lastSet = set;
        }

        timer.reset();
        timer.start();

        for (ListDisjointSet set : setList){
            firsSet.isDisjoint(set);
        }

        timer.stop();

        return timer.getTimeInMillis();
    }

}
