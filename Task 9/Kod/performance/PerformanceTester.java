package performance;

import core.Tree;
import generation.Generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PerformanceTester<T> {
    private Timer timer;
    private Generator<T> generator;
    private Tree<T> tree;
    private Random rng;

    public PerformanceTester(Generator<T> generator, Tree<T> tree) {
        this.generator = generator;
        this.tree = tree;
        this.timer = new Timer();
        this.rng = new Random();
    }

    public void addingTest(int[] sizes){
        List<T> list = new ArrayList<>();

        System.out.println("\nAdding test:\n");

        for (int size : sizes){
            tree.clear();
            list.clear();
            timer.reset();

            list.addAll(generator.generate(size));


            timer.start();

            for (T element : list){

                tree.add(element);

            }
            timer.stop();
            
            System.out.println(timer.getTimeInMillis());
        }
    }

    public void findingTest(int[] sizes){
        List<T> list = new ArrayList<>();

        System.out.println("\nFinding test:\n");

        for (int size : sizes){
            tree.clear();
            list.clear();
            timer.reset();

            list.addAll(generator.generate(size));

            for (T element : list){
                tree.add(element);
            }

            Collections.shuffle(list, rng);
            timer.start();

            for (T element : list){
                tree.find(element);
            }

            timer.stop();
            System.out.println(timer.getTimeInMillis());
        }
    }

    public void removingTest(int[] sizes){
        List<T> list = new ArrayList<>();

        System.out.println("\nRemoving test:\n");

        for (int size : sizes){
            tree.clear();
            list.clear();
            timer.reset();

            list.addAll(generator.generate(size));

            for (T element : list){
                tree.add(element);
            }

            Collections.shuffle(list, rng);
            timer.start();

            for (T element : list){
                tree.remove(element);
            }

            timer.stop();
            System.out.println(timer.getTimeInMillis());
        }
    }

}
