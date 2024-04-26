package algorithms.pivotSelectors;

import java.util.List;

public interface PivotSelector<T> {
    T selectPivot(List<T> list);
}
