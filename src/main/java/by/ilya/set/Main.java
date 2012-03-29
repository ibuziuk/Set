package by.ilya.set;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 23.3.12
 * Time: 4.02
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        Set mySet = new MyAutoArray();

        Person person = new Person("Ilya", "Buziuk");
        Person person1 = new Person("Ila", "Buziuk");
        Person person2 = new Person("Joo", "Black");
        Person person3 = new Person("Joo", "Black");

        System.out.println(mySet.add(person));
        System.out.println(mySet.add(person1));
        System.out.println(mySet.add(person2));
        System.out.println(mySet.add(person3));

        System.out.println(mySet.toArray().length);

        for (Object x : mySet) {
            System.out.println(x.hashCode());
        }


        //    todo ----> tests


//        Set mySet = new MySortSet();
//        long time0 = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            mySet.add(i);
//        }
//        long time1 = System.currentTimeMillis();
//        for (int i = 2000; i < 12000; i++) {
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


