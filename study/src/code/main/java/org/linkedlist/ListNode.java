package org.example.linkedlist;

public class ListNode<T> {
    T item;
    ListNode<T> next;

    public ListNode(T item) {
        this.item = item;
        this.next = null;
    }
}