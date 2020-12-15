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
            throw new IllegalArgumentException("initialCapacity must be > 0");
        }

        //noinspection unchecked
        this.items = (E[]) new Object[initialCapacity];
    }

    public void trimToSize() {
        items = Arrays.copyOf(items, size);
    }

    public void ensureCapacity(int minCapacity) {
        if (items.length < minCapacity) {
            items = Arrays.copyOf(items, minCapacity);
        }
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
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
        for (int i = 0; i < size; i++) {
            if (items[i] == object) {
                return true;
            }
        }

        return false;
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
            if (currentIndex == size) {
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
        return new Object[0];
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
    public boolean add(E object) {
        if (size >= items.length) {
            increaseCapacity();
        }

        items[size] = object;
        size++;
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(object)) {
                items[i] = null;
                size--;
                modCount++;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (int i = 0; i < collection.size(); i++) {
            if (!collection.contains(items[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            throw new NullPointerException("Specified collection is empty");
        }

        for (E e : collection) {
            add(e);
        }


        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and < " + size);
        }
        if (collection.isEmpty()) {
            throw new NullPointerException("Specified collection is empty");
        }

        System.arraycopy(items, index, items, index + collection.size(), collection.size());

        for (E e : collection) {
            items[index] = e;
            index++;
            size++;
            modCount++;
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            throw new NullPointerException("Specified collection is empty");
        }

        for (int i = 0; i < size; i++) {
            if (collection.contains(items[i])) {
                remove(i);
                i--;
            }
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            throw new NullPointerException("Specified collection is empty");
        }

        for (int i = 0; i < size; i++) {
            if (!collection.contains(items[i])) {
                remove(i);
                i--;
            }
        }

        return true;
    }

    @Override
    public void clear() {
        //noinspection unchecked
        items = (E[]) new Object[items.length];
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and < length = " + size());
        }

        return (E) items[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and < length = " + size());
        }

        items[index] = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and <= length = " + size());
        }

        size++;
        modCount++;

        if (size >= items.length) {
            increaseCapacity();
        }

        if (size + 1 - index >= 0) {
            System.arraycopy(items, index, items, index + 1, size + 1 - index);
        }

        items[index] = element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and < length = " + size());
        }

        size--;
        modCount++;
        E removed = items[index];

        System.arraycopy(items, index + 1, items, index, size - index + 1);

        return removed;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(items[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size; i >= 0; i--) {
            if (object.equals(items[i])) {
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
        return Arrays.toString(items);
    }
}
