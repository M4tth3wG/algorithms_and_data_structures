package core;

public interface Tree<T> {
    boolean add(T value);

    boolean remove(T value);

    T find(T value);

    int size();

    void clear();

    boolean isEmpty();

    boolean contains(T value);
}
