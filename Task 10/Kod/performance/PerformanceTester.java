package performance;

import disjointSets.DisjointSet;

import java.util.List;

public abstract class PerformanceTester<T extends DisjointSet> {
    Timer timer;
    Generator<T> generator;

    public PerformanceTester(Timer timer, Generator<T> generator) {
        this.timer = timer;
        this.generator = generator;
    }

    public abstract long joiningSetsTest(int size);

    public abstract long findingSetTest(int size);

    public abstract long checkingIfDisjointTest(int size);
}
