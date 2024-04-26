package generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class ShuffledIntegerArrayListGenerator implements Generator<Integer>{
    private Random rng;

    public ShuffledIntegerArrayListGenerator() {
        this.rng = new Random();
    }

    @Override
    public List<Integer> generate(int size) {
        List<Integer> returnList = new ArrayList<>();

        for (int i = 0; i < size; i++){
            returnList.add(i);
        }

        Collections.shuffle(returnList, rng);

        return returnList;
    }
}
