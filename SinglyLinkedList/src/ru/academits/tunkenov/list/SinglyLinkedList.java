package ru.academits.tunkenov.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getCount() {
        return count;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Current list is empty.");
        }

        return head.getData();
    }

    private void checkIndex(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("index = " + index + ", this data out of length, index must be >= 0 and " + "< " + count);
        }
    }

    private ListItem<T> getItemByIndex(int index) {
        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        return currentItem;
    }

    public T getData(int index) {
        checkIndex(index);

        return getItemByIndex(index).getData();
    }

    public T setData(int index, T data) {
        checkIndex(index);

        ListItem<T> item = getItemByIndex(index);
        T oldData = item.getData();
        item.setData(data);

        return oldData;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Current list is empty.");
        }

        T deletedData = head.getData();
        head = head.getNext();
        count--;

        return deletedData;
    }

    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);
        T deletedData = previousItem.getNext().getData();
        previousItem.setNext(previousItem.getNext().getNext());

        count--;

        return deletedData;
    }

    public boolean remove(T data) {
        if (count == 0) {
            return false;
        }

        if (head.getData().equals(data)) {
            removeFirst();
            return true;
        }

        for (ListItem<T> next = head.getNext(), previous = head; next != null; previous = next, next = next.getNext()) {
            if (next.getData().equals(data)) {
                previous.setNext(next.getNext());
                count--;

                return true;
            }
        }

        return false;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        checkIndex(index);

        if (index == 0) {
            addFirst(data);
            return;
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);
        ListItem<T> newItem = new ListItem<>(data, previousItem.getNext());

        previousItem.setNext(newItem);

        count++;
    }

    public void add(T data) {
        add(count, data);
    }

    public void reverse() {
        if (count <= 1) {
            return;
        }

        ListItem<T> last = head;
        ListItem<T> previous = last.getNext();

        last.setNext(previous.getNext());
        previous.setNext(last);

        for (ListItem<T> next = last.getNext(); next != null; previous = next, next = last.getNext()) {
            last.setNext(next.getNext());
            next.setNext(previous);
        }

        head = previous;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copyList = new SinglyLinkedList<>();

        if (count == 0) {
            return copyList;
        }

        ListItem<T> copyItem = new ListItem<>(head.getData());
        copyList.head = copyItem;
        ListItem<T> currentItem = head;

        for (int i = 1; i < count; i++) {
            currentItem = currentItem.getNext();
            ListItem<T> copyNextItem = new ListItem<>(currentItem.getData());
            copyItem.setNext(copyNextItem);
            copyItem = copyItem.getNext();
        }

        return copyList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        if (count == 0) {
            sb.append("]");
            return sb.toString();
        }

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            sb.append(p.getData());
            sb.append(", ");
        }

        sb.append("]");
        sb.deleteCharAt(sb.length() - 3);
        sb.deleteCharAt(sb.length() - 2);

        return sb.toString();
    }
}