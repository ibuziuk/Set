package by.ilya.set;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 23.3.12
 * Time: 4.00
 * To change this template use File | Settings | File Templates.
 */
public class MySet<T> implements Set<T> {

    private Object[] mySet = new Object[0];


    @Override
    public int size() {

        return mySet.length;
    }


    @Override
    public boolean isEmpty() {

        if (mySet.length == 0) {
            return true;
        }

        return false;
        /* throw new UnsupportedOperationException();*/
    }


    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < mySet.length; i++) {
            if (mySet[i] == o) {
                return true;
            }
        }


        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                if (count < size()) {
                    return true;
                }

                return false;
            }

            @Override
            public T next() {
                if (count == size()) {
                    throw new NoSuchElementException();
                }

                return (T) mySet[count++];
            }

            @Override
            public void remove() {
                if (isEmpty()) {
                    throw new UnsupportedOperationException();
                }

                MySet.this.remove(mySet[count]);
            }
        };
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(mySet, mySet.length)/*mySet.clone()*/;
    }


    @Override
    public <T> T[] toArray(T[] a) {
        System.arraycopy(mySet, 0, a, 0, mySet.length);
        return a;
    }


    @Override
    public boolean add(T t) {

        /*Check matches*/

        if (contains(t)) {
            return false;
        }


/*         for (int i = 0; i < mySet.length; i++){
    if (mySet[i].equals(t)){
        return false;
    }
}*/


        /* new array length ++*/
        Object[] myNewSet = new Object[mySet.length + 1];


        /*Copy data*/
        for (int i = 0; i < mySet.length; i++) {
            myNewSet[i] = mySet[i];
        }

        /*add new object*/
        myNewSet[myNewSet.length - 1] = t;


        /*mySet = myNewSet;*/

        mySet = myNewSet;

        return true;

    }


    @Override
    public boolean remove(Object o) {

        int index = 0;

        // if there is an element to delete
        if (contains(o)) {
            // fix index of removable element
            for (int i = 0; i < mySet.length; i++) {
                if (mySet[i] == o) {
                    index = i;
                }
            }

            //change elements
            for (; index < mySet.length - 1; index++) {
                mySet[index] = mySet[index + 1];
            }

            // new array
            Object[] myNewSet = new Object[mySet.length - 1];

            for (int j = 0; j < mySet.length - 1; j++) {
                myNewSet[j] = mySet[j];

            }
            mySet = myNewSet;


            return true;


        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (int i = 0; i < c.toArray().length; i++) {
            if (!contains(c.toArray()[i])) {

                return false;
            }

        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        int i = 0;

        int l = mySet.length;

        for (; i < c.toArray().length; i++) {
            add((T) c.toArray()[i]);
        }

        if (mySet.length == l) {
            return false;
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        int matches = 0;
        boolean r = false;

        for (int i = mySet.length - 1; i > -1; i--) {
            if (!c.contains(mySet[i])) {
                remove(mySet[i]);
                r = true;
            }
        }

        if (r) {
            return true;
        }


        /*for(int i = 0; i < mySet.length; i++){
                    if (!c.contains(mySet[i])){
                        remove(mySet[i]);
                    }
                }
        */

        /*     int matches = 0;
 int index = 0;

  for(int i=0; i < c.toArray().length; i++){
     if (contains(c.toArray()[i])){
        *//* myNewSet[matches]=c.toArray()[i];*//*
                  ++matches;
              }
          }

          Object[] myNewSet = new Object[matches];

          for (Object element : c) {

          }



         *//* Iterator iterator  = c.iterator();
          Object element;
          for (;iterator.hasNext(); element = iterator.next())*//*




          mySet = myNewSet;

          if (matches == 0){
              return false;
          }*/

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        int l = mySet.length;

        for (int i = 0; i < c.toArray().length; i++) {
            if (contains(c.toArray()[i])) {
                remove(c.toArray()[i]);
            }
        }

        if (mySet.length == l) {
            return false;
        }

        return true;
    }

    @Override
    public void clear() {

        mySet = new Object[0];
    }


/*    @Override
public int hashCode(){
return (int)id;
*//*return (int)((id>>>32) ^ id);*//* // получается равновесный hashCode, правильно реагирует на изменение старших 32 битов long'a
    }

    @Override
    public boolean equals(Object object){
        return true;
    }*/


}
