package performance;

import disjointSets.ForestDisjointSet;
import disjointSets.ListDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class ForestDisjointSetGenerator implements Generator<ForestDisjointSet> {

    @Override
    public List<ForestDisjointSet> generate(int size) {
        List<ForestDisjointSet> returnList = new ArrayList<>();

        for (int i = 0; i < size; i++){
            ForestDisjointSet set = new ForestDisjointSet();
            set.makeSet();
            returnList.add(set);
        }

        return returnList;

    }
}
