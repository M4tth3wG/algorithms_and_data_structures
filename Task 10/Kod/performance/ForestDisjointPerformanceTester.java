package performance;

import disjointSets.ForestDisjointSet;
import disjointSets.ForestDisjointSet;

import java.util.List;

public class ForestDisjointPerformanceTester extends PerformanceTester<ForestDisjointSet> {
    public ForestDisjointPerformanceTester(Timer timer, Generator<ForestDisjointSet> generator) {
        super(timer, generator);
    }

    @Override
    public long joiningSetsTest(int size) {
        List<ForestDisjointSet> setList = generator.generate(size);
        ForestDisjointSet firsSet = setList.get(0);

        timer.reset();
        timer.start();

        for (ForestDisjointSet set : setList){
            firsSet.join(set);
            firsSet = set;
        }

        timer.stop();

        return timer.getTimeInMillis();
    }

    @Override
    public long findingSetTest(int size) {
        List<ForestDisjointSet> setList = generator.generate(size);
        ForestDisjointSet firsSet = setList.remove(0);
        ForestDisjointSet lastSet = null;

        for (ForestDisjointSet set : setList){
            firsSet.join(set);
            lastSet = set;
        }

        timer.reset();
        timer.start();

        for (ForestDisjointSet set : setList){
            set.findSet();
        }

        timer.stop();

        return timer.getTimeInMillis();
    }

    @Override
    public long checkingIfDisjointTest(int size) {
        List<ForestDisjointSet> setList = generator.generate(size);
        ForestDisjointSet firsSet = setList.remove(0);
        ForestDisjointSet lastSet = null;

        for (ForestDisjointSet set : setList){
            firsSet.join(set);
            lastSet = set;
        }

        timer.reset();
        timer.start();

        for (ForestDisjointSet set : setList){
            firsSet.isDisjoint(set);
        }

        timer.stop();

        return timer.getTimeInMillis();
    }
}
