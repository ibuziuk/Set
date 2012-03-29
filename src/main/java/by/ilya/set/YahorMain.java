package by.ilya.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static by.ilya.set.SetTester.add;
import static by.ilya.set.SetTester.contains;
import static by.ilya.set.SetTester.delete;

/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 23.3.12
 * Time: 9.59
 * To change this template use File | Settings | File Templates.
 */
public class YahorMain {
    public static void main(String[] args) {

        /*My collections*/
        Set mySet = new MySet();  // first option, have to grow length every time
        Set mySortSet = new MySortSet(); // second option, the same as first + binary search
        Set myAutoArray = new MyAutoArray(); // third option, the same as second + auto grow if (size==length) length*2

        /*Java collections*/
        Set hashSet = new HashSet();
        Set treeSet = new TreeSet();
        //




                          /*ADDITION*/
        System.out.println("ADDITION------------------------");
        System.out.print("mySet = ");
        add(mySet);

        System.out.print("mySortSet = ");
        add(mySortSet);

        System.out.print("myAutoArray = ");
        add(myAutoArray);

        System.out.print("hashSet = ");
        add(hashSet);

        System.out.print("treeSet = ");
        add(treeSet);


        System.out.println("\n");


                            /*CONTAINS*/
        System.out.println("CONTAINS------------------------");
        System.out.print("mySet = ");
        contains(mySet);

        System.out.print("mySortSet = ");
        contains(mySortSet);

        System.out.print("myAutoArray = ");
        contains(myAutoArray);

        System.out.print("hashSet = ");
        contains(hashSet);

        System.out.print("treeSet = ");
        contains(treeSet);


        System.out.println("\n");



                             /*REMOVAL*/
        System.out.println("REMOVAL------------------------");
        System.out.print("mySet = ");
        delete(mySet);

        System.out.print("mySortSet = ");
        delete(mySortSet);

        System.out.print("myAutoArray = ");
        delete(myAutoArray);

        System.out.print("hashSet = ");
        delete(hashSet);

        System.out.print("treeSet = ");
        delete(treeSet);


//        Set mySet = new MyAutoArray();
//        long time0 = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            mySet.add(i);
//        }
//        long time1 = System.currentTimeMillis();
//        for (int i = 2000; i < 120000; i++) {
//            mySet.contains(i);
//        }
//        long time2 = System.currentTimeMillis();
//        Iterator iterator = mySet.iterator();
//        while (iterator.hasNext()) {
//            iterator.next();
//            iterator.remove();
//        }
//        long time3 = System.currentTimeMillis();
//        System.out.println(String.format("time1 - time0 = %s\ntime2 - time1 = %s\ntime3 - time2 = %s",
//                time1 - time0, time2 - time1, time3 - time2));
//        // time1 - time0 = 145
//        // time2 - time1 = 44
//        // time3 - time2 = 203
    }
}
