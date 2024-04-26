package testing;

import java.util.List;

public interface Generator<T> {
	List<T> generate(int size);
}
