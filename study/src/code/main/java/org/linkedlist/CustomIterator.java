package org.example.linkedlist;

import java.util.Iterator;

public class CustomIterator<T> implements Iterator<T> {
    CustomList<T> list;
    private int nextIndex = 0;

    public CustomIterator(CustomList<T> customList) {
        this.list = customList;
    }

    @Override
    public boolean hasNext() {
        return nextIndex < list.length();
    }

    @Override
    public T next() {
        T result = list.get(nextIndex++);
        return result;
    }
}
