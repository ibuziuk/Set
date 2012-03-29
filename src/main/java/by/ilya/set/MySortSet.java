package by.ilya.set;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 26.3.12
 * Time: 16.16
 * To change this template use File | Settings | File Templates.
 */
public class MySortSet<T> implements Set<T> {

    private Object[] mySet = new Object[0];
    int size;

    private int search(Object o) {
        int first = 0;
        int last = mySet.length;
        int mid;

        while (first < last) {
            mid = first + (last - first) / 2;

            if (o.hashCode() <= mySet[mid].hashCode()) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }

        return last;

    }

    @Override
    public int size() {

        return mySet.length; // size
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


        int last = mySet.length;


        if (isEmpty()) {

            return false;
        } else if (mySet[0].hashCode() > o.hashCode()) {

            return false;
        } else if (mySet[last - 1].hashCode() < o.hashCode()) {

            return false;
        }

        last = search(o);

        if (mySet[last].equals(o)) {
            return true;
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

                MySortSet.this.remove(mySet[count]);
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

    private void add(int index, Object o) {
        Object[] myNewSet = new Object[mySet.length + 1];
        System.arraycopy(mySet, 0, myNewSet, 0, index);
        myNewSet[index] = o;
        System.arraycopy(mySet, index, myNewSet, index + 1, mySet.length - index);
        mySet = myNewSet;
    }


    @Override
    public boolean add(T t) {

        if (contains(t)) {
            return false;
        }

        int last = search(t);

        add(last, t);
        return true;
    }


    private void remove(int index, Object o) {
        Object[] myNewSet = new Object[mySet.length - 1];
        System.arraycopy(mySet, 0, myNewSet, 0, index);
        System.arraycopy(mySet, index + 1, myNewSet, index, mySet.length - index - 1);
        mySet = myNewSet;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }
        int last = search(o);

        remove(last, o);
        return true;
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
}
