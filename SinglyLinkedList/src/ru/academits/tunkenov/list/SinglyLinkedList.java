package ru.academits.tunkenov.list;

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
            throw new NullPointerException("Current list is empty.");
        }

        return head.getData();
    }

    private void indexCheck(int index) {
        if (index < 0 || index >= count) {
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
        indexCheck(index);

        return getItemByIndex(index).getData();
    }

    public T setData(int index, T data) {
        indexCheck(index);

        ListItem<T> oldItem = new ListItem<>(getItemByIndex(index).getData());
        getItemByIndex(index).setData(data);

        return oldItem.getData();
    }

    public T removeFirst() {
        ListItem<T> remoteItem = new ListItem<>(head.getData());
        head = head.getNext();
        count--;
        return remoteItem.getData();
    }

    public T remove(int index) {
        indexCheck(index);

        ListItem<T> previousItem = getItemByIndex(index - 1);
        ListItem<T> currentItem = getItemByIndex(index);
        ListItem<T> remoteItem = new ListItem<>(currentItem.getData());
        count--;

        if (index == 0) {
            head = head.getNext();
            return remoteItem.getData();
        }

        previousItem.setNext(currentItem.getNext());

        return remoteItem.getData();
    }

    public boolean remove(T data) {
        ListItem<T> newItem = new ListItem<>(data);

        if (count < 1) {
            return false;
        }

        if (head.getData() == newItem.getData()) {
            removeFirst();
            return true;
        }

        for (ListItem<T> p = head.getNext(), previous = head; p != null; previous = p, p = p.getNext()) {
            if (p.getData() == newItem.getData()) {
                previous.setNext(p.getNext());
                count--;
                return true;
            }
        }

        return false;
    }

    public void addFirst(T data) {
        ListItem<T> newItem = new ListItem<>(data);
        newItem.setNext(head);
        head = newItem;
        count++;
    }

    public void add(int index, T data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        ListItem<T> currentItem = head;

        for (int i = 0; i < index - 1; i++) {
            currentItem = currentItem.getNext();
        }

        ListItem<T> newItem = new ListItem<>(data);

        newItem.setNext(currentItem.getNext());
        currentItem.setNext(newItem);
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
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();

        if (count < 1) {
            return copy;
        }

        ListItem<T> copyItem;
        for (int i = 0; i < count; i++) {
            copyItem = new ListItem<>(getData(i));
            copy.add(copyItem.getData());
        }

        return copy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            sb.append(p.getData());
            sb.append(", ");
        }

        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }
}

