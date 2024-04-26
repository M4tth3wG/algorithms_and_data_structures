package algorithms.pivotSelectors;

import java.util.List;

public class FirstElementPivot<T> implements PivotSelector<T>{

    @Override
    public T selectPivot(List<T> list) {
        return list.remove(0);
    }
}
