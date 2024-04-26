package algorithms.pivotSelectors;

import java.util.List;
import java.util.Random;

public class RandomElementPivot<T> implements PivotSelector<T>{

    @Override
    public T selectPivot(List<T> list) {
        Random rng = new Random();
        return list.remove(rng.nextInt(0, list.size()));
    }
}
