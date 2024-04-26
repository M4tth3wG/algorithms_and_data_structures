package performance;

import disjointSets.DisjointSet;
import disjointSets.ForestDisjointSet;
import disjointSets.ListDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class ListDisjointSetGenerator implements Generator<ListDisjointSet> {

    @Override
    public List<ListDisjointSet> generate(int size) {
        List<ListDisjointSet> returnList = new ArrayList<>();

        for (int i = 0; i < size; i++){
            ListDisjointSet set = new ListDisjointSet();
            set.makeSet();

            returnList.add(set);
        }

        return returnList;
    }
}
