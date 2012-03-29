package by.ilya.set;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 27.3.12
 * Time: 7.53
 * To change this template use File | Settings | File Templates.
 */
public class MyAutoArray<T> implements Set<T> {
    private int size;
    private Object[] mySet;

    private class FindData {
        int index;
        boolean find;

        public FindData(int index, boolean find) {
            this.index = index;
            this.find = find;
        }
    }

    private FindData search(Object o) {


        int last = size;
        int first = 0;
        int mid;

        if (isEmpty()) {

            return new FindData(0, false);
        } else if (mySet[0].hashCode() > o.hashCode()) {

            return new FindData(0, false);
        } else if (mySet[last - 1].hashCode() < o.hashCode()) {

            return new FindData(size, false);
        }

        int elementHash = o.hashCode();

        while (first < last) {
            mid = first + (last - first) / 2;

            if (elementHash <= mySet[mid].hashCode()) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }

        int index = last;

        while (index < size && elementHash == mySet[index].hashCode()) {
            if (mySet[index].equals(o)) {
                return new FindData(index, true);
            }
            index++;
        }

        index = last - 1;

        while (last >= 0 && elementHash == mySet[index].hashCode()) {
            if (mySet[index].equals(o)) {
                return new FindData(index, true);
            }
            index--;
        }

        return new FindData(last, false);

    }


    public MyAutoArray() {
        mySet = new Object[10];
    }

    protected void grow() {
        mySet = Arrays.copyOf(mySet, mySet.length * 2);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return search(o).find;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                if (count < size) {
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                if (count == size)
                    throw new NoSuchElementException();
                return (T) mySet[count++];
            }

            @Override
            public void remove() {
                if (isEmpty()) {
                    throw new IllegalStateException();
                }

                MyAutoArray.this.remove(mySet[count]);
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(mySet, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        System.arraycopy(mySet, 0, a, 0, size);
        return a;
    }

    private void add(int index, Object o) {
        System.arraycopy(mySet, index, mySet, index + 1, size - index);
        mySet[index] = o;
        size++;
    }

    @Override
    public boolean add(T t) {

        FindData findData = search(t);

        if (findData.find == true) {
            return false;
        }

        if (mySet.length == size) {
            grow();
        }

        add(findData.index, t);

        return true;
    }


    private void remove(int index, Object o) {
        System.arraycopy(mySet, index + 1, mySet, index, size - index - 1);
        mySet[size - 1] = null;
        size--;
    }

    @Override
    public boolean remove(Object o) {
        FindData findData = search(o);

        if (findData.find == false) {
            return false;
        }

        if (mySet.length == size) {
            grow();
        }

        remove(findData.index, o);

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {


        int l = size;

        for (T element : c) {
            add(element);
        }

        if (size == l) {
            return false;
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {   // TODO

        int counter = 0;

        for (int i = 0; i < size; i++) {
            if (!c.contains(mySet[i])) {
                mySet[i] = null;
                counter++;
            }
        }

        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i != j) {
                mySet[j] = mySet[i];
                mySet[i] = null;
            }
            if (mySet[j] != null) {
                j++;
            }
        }


//        for (int i = 0; i <= size; i++) {
//            if (mySet[i] == null) {
//                for (int j = i; j <= size; j++) {
//                    if (mySet[j] != null) {
//                        mySet[i] = mySet[j];
//                        mySet[j] = null;
//                        break;
//                    }
//
//                }
//            }
//        }

        size = size - counter;

        if (counter != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        int l = size;

        for (Object element : c) {
            if (contains(element)) {
                remove(element);
            }
        }

        if (size == l) {
            return false;
        }

        return true;
    }

    @Override
    public void clear() {
        mySet = new Object[10];
        size = 0;
    }
}
