import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ArrayHeap<T> implements Heap<T> {
    private T[] heapArray;
    private Comparator<T> comparator;
    private int initialCapacity;
    private int size = 0;

    public ArrayHeap(int initialCapacity, Comparator<T> comparator) {
        this.initialCapacity = initialCapacity;
        this.heapArray = (T[]) new Object[initialCapacity];
        this.comparator = comparator;
    }

    @Override
    public void clear() {
        this.heapArray = (T[]) new Object[initialCapacity];
        size = 0;
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        ensureCapacity();

        heapArray[size] = element;
        size++;

        //repairHeap();
        swim(size - 1);
    }

    @Override
    public T minimum() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T minimum = heapArray[0];

        swap(0, size - 1);

        heapArray[size - 1] = null;
        size--;
        sink(0);

        return minimum;
    }

    private void ensureCapacity() {
        if (size == heapArray.length) {
            heapArray = Arrays.copyOf(heapArray, size * 2);
        }
    }

    private void repairHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            sink(i);
        }
    }

    private void sink(int start) {
        int smallerElementIndex = 2 * start + 1;

        if (smallerElementIndex < size) {
            if (smallerElementIndex + 1 < size &&
                    comparator.compare(heapArray[smallerElementIndex], heapArray[smallerElementIndex + 1]) > 0)
                smallerElementIndex++;

            if (comparator.compare(heapArray[start], heapArray[smallerElementIndex]) > 0) {
                swap(start, smallerElementIndex);
                sink(smallerElementIndex);
            }
        }
    }

    private void swim(int start){
        if (start >= size){
            throw new IndexOutOfBoundsException();
        }

        int i = start;
        boolean isDone = false;

        while (i > 0 && !isDone){
            int parentIndex = (i - 1) / 2;

            if (comparator.compare(heapArray[i], heapArray[parentIndex]) < 0){
                swap(i, parentIndex);
                i = parentIndex;
            }
            else {
                isDone = true;
            }
        }
    }

    private void swap(int left, int right) {
        T tmp = heapArray[left];

        heapArray[left] = heapArray[right];
        heapArray[right] = tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String asOneLineString() {
        if (size == 0) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("[ ");

        for (T element : heapArray) {
            if (element == null) {
                break;
            }

            buffer.append(element + ", ");
        }
        buffer.setLength(buffer.length() - 2);
        buffer.append(" ]");

        return buffer.toString();
    }

    @Override
    public String toString() {
        if (size == 0) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append(heapArray[0]).append("\n");

        int startIndex = 1;
        int endIndex = 2;

        while (startIndex < size) {
            for (int i = startIndex; i <= endIndex && i < size; i++) {
                buffer.append(heapArray[i]).append(", ");
            }
            buffer.setLength(buffer.length() - 2);
            buffer.append("\n");

            startIndex = (2 * startIndex) + 1;
            endIndex = (endIndex + 1) * 2;
        }

        buffer.setLength(buffer.length() - 1);
        return buffer.toString();
    }
}
