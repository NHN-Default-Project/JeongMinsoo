package org.example.linkedlist;

public class CustomList<T> {
    ListNode<T> head;
    ListNode<T> tail;

    public CustomList() {
        this.head = null;
        this.tail = null;
    }

    public int length() {
        int length;
        if (head == null) {
            throw new IllegalArgumentException("리스트가 비어있습니다!");
        } else {
            length = 1;
            ListNode<T> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
                length++;
            }
        }

        return length;
    }

    public T get(int index) {
        if (index + 1 > this.length()) {
            throw new IndexOutOfBoundsException("index가 깁니다.");
        }

        ListNode<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.item;
    }

    public void add(T item) {
        ListNode<T> newNode = new ListNode<>(item);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public CustomIterator<T> iterator() {
        return new CustomIterator<T>(this);
    }
}
