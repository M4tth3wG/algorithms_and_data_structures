package incrementalFunctions;

import core.IncrementalFunction;

public class LinearIncrementalFunction<T> implements IncrementalFunction<T> {
    private int linearCoefficient;

    public LinearIncrementalFunction(int linearCoefficient) {
        this.linearCoefficient = linearCoefficient;
    }

    public LinearIncrementalFunction() {
        this(1);
    }

    @Override
    public int shift(T object, int trial) {
        return linearCoefficient * trial;
    }
}
