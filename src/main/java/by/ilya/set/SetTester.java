package by.ilya.set;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 28.3.12
 * Time: 6.02
 * To change this template use File | Settings | File Templates.
 */
public class SetTester {

    private static final int SIZE = 10000;


    private static long start;
    private static long stop;

    static void add(Set set) {

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            set.add(i);
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);
        System.out.print("-------------------------------\n");
    }


    static void delete(Set set) {

        Iterator iterator = set.iterator();

        start = System.currentTimeMillis();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        stop = System.currentTimeMillis();
        System.out.println(stop - start);
        System.out.print("-------------------------------\n");

    }

    static void contains(Set set){
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            set.contains(i);
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);
        System.out.print("-------------------------------\n");

    }


}
