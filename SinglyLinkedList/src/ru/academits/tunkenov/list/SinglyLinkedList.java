package ru.academits.tunkenov.list;

import java.util.NoSuchElementException;
import java.util.Objects;

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
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index = " + index + ", this index out of length, index must be >= 0 and < " + count);
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

        if (Objects.equals(head.getData(), data)) {
            removeFirst();
            return true;
        }

        for (ListItem<T> current = head.getNext(), previous = head; current != null; previous = current, current = current.getNext()) {
            if (Objects.equals(current.getData(), data)) {
                previous.setNext(current.getNext());
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
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("index = " + index + ", this index out of length, index must be >= 0 and <= " + count);
        }

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

        for (ListItem<T> currentItem = head.getNext(); currentItem != null; currentItem = currentItem.getNext()) {
            copyItem.setNext(currentItem);
            copyItem = currentItem;
        }

        copyList.count = count;

        return copyList;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            sb.append(p.getData());
            sb.append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}