package core;

public interface IncrementalFunction<T> {
	int shift(T object, int trial);
}
