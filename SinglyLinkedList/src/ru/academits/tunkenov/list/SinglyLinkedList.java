package ru.academits.tunkenov.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {

    }

    public int getLength() {
        return count;
    }

    public T getValue() {
        if (head == null) {
            return null;
        }

        return head.getData();
    }

    public T getValue(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index = " + index + ", this value out of length, index must be >= 0 and " +
                    "< " + count);
        }

        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        return currentItem.getData();
    }

    public T setValue(int index, T data) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index = " + index + ", this value out of length, index must be >= 0 and " +
                    "< " + count);
        }

        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        ListItem<T> oldItem = currentItem;
        currentItem.setData(data);

        return oldItem.getData();
    }

    public T remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index = " + index + ", this value out of length, index must be >= 0 and " +
                    "< " + count);
        }

        ListItem<T> previousItem = head;
        ListItem<T> currentItem = head;
        ListItem<T> newItem = head;

        for (int i = 0; i < index + 1; i++) {
            if (i == index - 1) {
                previousItem = currentItem;
            }

            if (i == index) {
                newItem = currentItem;
            }

            currentItem = currentItem.getNext();
        }

        count--;
        previousItem.setNext(currentItem);
        return newItem.getData();
    }

    public boolean remove(ListItem<T> item) {
        if (head.getData().equals(item.getData())) {
            head = head.getNext();
            count--;
            return true;
        }

        for (ListItem<T> p = head.getNext(), prev = head; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(item.getData())) {
                prev.setNext(p.getNext());
                count--;
                return true;
            }
        }

        return false;
    }

    public T removeFront() {
        ListItem<T> p = head;
        head = head.getNext();
        return p.getData();
    }

    public void addFront(ListItem<T> newItem) {
        newItem.setNext(head);
        head = newItem;
        count++;
    }

    public void add(ListItem<T> newItem) {
        if (head == null) {
            head = newItem;
            count++;
        } else {
            for (ListItem<T> p = head, prev = null; ; prev = p, p = p.getNext()) {
                if (p == null) {
                    prev.setNext(newItem);
                    count++;
                    break;
                }
            }
        }
    }

    public void add(int index, ListItem<T> newItem) {
        if (index < 0 || index >= getLength()) {
            throw new IndexOutOfBoundsException("index = " + index + ", this value out of length, index must be >= 0 and " +
                    "< " + getLength());
        }

        if (index == 0) {
            addFront(newItem);
        } else {
            ListItem<T> currentItem = head;

            for (int i = 1; i < index - 1; i++) {
                currentItem = currentItem.getNext();
            }

            newItem.setNext(currentItem.getNext());
            currentItem.setNext(newItem);
            count++;
        }
    }

    public void reverse() {
        if (count <= 1) {
            throw new IllegalArgumentException("List have <= 1 items, must be > 2");
        }

        ListItem<T> last = head;
        ListItem<T> prev = last.getNext();

        last.setNext(prev.getNext());
        prev.setNext(last);

        for (ListItem<T> next = last.getNext(); next != null; prev = next, next = last.getNext()) {
            last.setNext(next.getNext());
            next.setNext(prev);
        }

        head = prev;
    }

    public static <T> void copy(SinglyLinkedList<T> source, SinglyLinkedList<T> destination) {
        if (source.getLength() < 1) {
            throw new IllegalArgumentException("List source is empty, must be > 0 items");
        }

        ListItem<T> p;
        for (int i = 0; i < source.getLength(); i++) {
            p = new ListItem<>(source.getValue(i));
            destination.add(p);
        }
    }

    public void printList() {
        StringBuffer sb = new StringBuffer();

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            sb.append(p.getData());
            sb.append(", ");
        }

        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
    }
}

