package ru.academits.tunkenov.my_array_list;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private int size;
    private E[] items;
    private int modCount;

    public MyArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[10];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity: " + initialCapacity + ", must be >= 0");
        }

        //noinspection unchecked
        items = (E[]) new Object[initialCapacity];
    }

    private void checkBoundInclusive(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and <= " + size);
        }
    }

    private void checkBoundExclusive(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and < " + size);
        }
    }

    public void trimToSize() {
        if (items.length > size) {
            items = Arrays.copyOf(items, size);
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (items.length < minCapacity) {
            items = Arrays.copyOf(items, minCapacity);
        }
    }

    private void increaseCapacity() {
        if (items.length == 0) {
            //noinspection unchecked
            items = (E[]) new Object[10];
        } else {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) > -1;
    }

    private class MyListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private final int oldModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Collection is over");
            }

            if (oldModCount != modCount) {
                throw new ConcurrentModificationException("The Collection has changed");
            }

            ++currentIndex;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(items, size, array.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, array, 0, size);

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public boolean add(E item) {
        add(size, item);

        return true;
    }

    @Override
    public boolean remove(Object object) {
        int index = indexOf(object);

        if (index > -1) {
            remove(index);
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(size, collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        checkBoundInclusive(index);

        if (collection == null) {
            throw new NullPointerException("Collection is null");
        }
        if (collection.isEmpty()) {
            return false;
        }

        ensureCapacity(collection.size() + size);

        System.arraycopy(items, index, items, index + collection.size(), size - index);

        int i = index;

        for (E e : collection) {
            items[i] = e;
            i++;
        }

        size += collection.size();
        modCount++;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection is null");
        }
        if (collection.isEmpty()) {
            return false;
        }

        boolean isChanged = false;

        for (int i = 0; i < size; i++) {
            if (collection.contains(items[i])) {
                remove(i);
                i--;
                isChanged = true;
            }
        }

        return isChanged;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection is null");
        }
        if (size == 0) {
            return false;
        }
        if (collection.isEmpty()) {
            clear();
            return true;
        }

        boolean isChanged = false;

        for (int i = 0; i < size; i++) {
            if (!collection.contains(items[i])) {
                remove(i);
                i--;
                isChanged = true;
            }
        }

        return isChanged;
    }

    @Override
    public void clear() {
        if (size > 0) {
            Arrays.fill(items, 0, size, null);
            modCount++;
            size = 0;
        }
    }

    @Override
    public E get(int index) {
        checkBoundExclusive(index);

        return items[index];
    }

    @Override
    public E set(int index, E item) {
        checkBoundExclusive(index);

        E oldItem = items[index];
        items[index] = item;
        return oldItem;
    }

    @Override
    public void add(int index, E item) {
        checkBoundInclusive(index);

        if (size == items.length) {
            increaseCapacity();
        }

        if (index != size) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }

        size++;
        modCount++;
        items[index] = item;
    }

    @Override
    public E remove(int index) {
        checkBoundExclusive(index);

        E removedItem = items[index];

        if (index != size) {
            System.arraycopy(items, index + 1, items, index, size - index);
        }

        items[size] = null;

        size--;
        modCount++;

        return removedItem;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }

        return -1;

    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(items[i]).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}
