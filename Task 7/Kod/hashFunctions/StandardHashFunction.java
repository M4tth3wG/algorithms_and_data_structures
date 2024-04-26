package hashFunctions;

import core.HashFunction;

import java.util.Objects;

public class StandardHashFunction<T> implements HashFunction<T> {

    @Override
    public int hashCode(T object) {
        return object.hashCode();
    }
}
