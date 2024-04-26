import disjointSets.ForestDisjointSet;
import disjointSets.ListDisjointSet;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        ListDisjointSet[] listSets = new ListDisjointSet[5];

        for (int i = 0; i < listSets.length; i++){
            listSets[i] = new ListDisjointSet();
            listSets[i].makeSet();
        }

        System.out.println("\nListDisjointSet TEST:\n");

        System.out.println("\n(listSets[0]).isDisjoint(listSets[1]): " + listSets[0].isDisjoint(listSets[1]));
        System.out.println("(listSets[0]).join(listSets[1]): " + listSets[0].join(listSets[1]));
        System.out.println("(listSets[0]).isDisjoint(listSets[1]): " + listSets[0].isDisjoint(listSets[1]));
        System.out.println("(listSets[0]).join(listSets[1]): " + listSets[0].join(listSets[1]));

        System.out.println("\nListDisjointSet.findSet(listSets[0]): " + listSets[0].findSet());
        System.out.println("ListDisjointSet.findSet(listSets[1]): " + listSets[1].findSet());

        System.out.println("\nlistSets[1].join(listSets[2]): " + listSets[1].join(listSets[2]));
        System.out.println("listSets[0].join(listSets[2]): " + listSets[0].join(listSets[2]));

        System.out.println("\nListDisjointSet.findSet(listSets[0]): " + listSets[0].findSet());
        System.out.println("ListDisjointSet.findSet(listSets[2]): " + listSets[2].findSet());


        ForestDisjointSet[] forestSets = new ForestDisjointSet[5];

        for (int i = 0; i < forestSets.length; i++){
            forestSets[i] = new ForestDisjointSet();
            forestSets[i].makeSet();
        }

        System.out.println("\nForestDisjointSet TEST:\n");

        System.out.println("\n(forestSets[0]).isDisjoint(forestSets[1]): " + forestSets[0].isDisjoint(forestSets[1]));
        System.out.println("(forestSets[0]).join(forestSets[1]): " + forestSets[0].join(forestSets[1]));
        System.out.println("(forestSets[0]).isDisjoint(forestSets[1]): " + forestSets[0].isDisjoint(forestSets[1]));
        System.out.println("(forestSets[0]).join(forestSets[1]): " + forestSets[0].join(forestSets[1]));

        System.out.println("\nForestDisjointSet.findSet(forestSets[0]): " + forestSets[0].findSet());
        System.out.println("ForestDisjointSet.findSet(forestSets[1]): " + forestSets[1].findSet());

        System.out.println("\nforestSets[1].join(forestSets[2]): " + forestSets[1].join(forestSets[2]));
        System.out.println("forestSets[0].join(forestSets[2]): " + forestSets[0].join(forestSets[2]));

        System.out.println("\nForestDisjointSet.findSet(forestSets[0]): " + forestSets[0].findSet());
        System.out.println("ForestDisjointSet.findSet(forestSets[2]): " + forestSets[2].findSet());
    }
}
