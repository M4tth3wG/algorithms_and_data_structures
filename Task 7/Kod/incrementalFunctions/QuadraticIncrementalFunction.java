package incrementalFunctions;

import core.IncrementalFunction;

public class QuadraticIncrementalFunction<T> implements IncrementalFunction<T> {
    private int linearCoefficient;
    private int quadraticCoefficient;

    public QuadraticIncrementalFunction(int linearCoefficient, int quadraticCoefficient) {
        this.linearCoefficient = linearCoefficient;
        this.quadraticCoefficient = quadraticCoefficient;
    }

    public QuadraticIncrementalFunction() {
        this(1, 1);
    }

    @Override
    public int shift(T object, int trial) {
        return (int) (linearCoefficient * trial + quadraticCoefficient * Math.pow(trial, 2));
    }
}
