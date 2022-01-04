package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private double facTion = 0.25;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            this.resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            this.resize(size * 2);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = addOne(nextLast);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        if ((double) size / items.length == facTion && items.length > 8) {
            resize(items.length / 2);
        }

        nextFirst = addOne(nextFirst);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if ((double) size / items.length == facTion && items.length > 8) {
            resize(items.length / 2);
        }

        nextLast = minusOne(nextLast);
        T item = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return item;
    }

    @Override
    public T get(int index) {
        if (size <= index || index < 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int currentIndex;

        ArrayDequeIterator() {
            currentIndex = 0;
        }

        public boolean hasNext() {
            return currentIndex < size;
        }

        public T next() {
            T item = get(currentIndex);
            currentIndex += 1;
            return item;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque<T> ad = (ArrayDeque<T>) o;
        if (ad.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (ad.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }


    private int addOne(int number) {
        if (number + 1 > items.length - 1) {
            return 0;
        }
        return number + 1;
    }

    private int minusOne(int number) {
        if (number - 1 < 0) {
            return items.length - 1;
        }
        return number - 1;
    }

    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        int start = addOne(nextFirst);
        int end = minusOne(nextLast);

        if (newSize > items.length) {
            if (end < start) {
                System.arraycopy(items, start, newItems, newSize / 2 - 1, size - start);
                System.arraycopy(items, 0, newItems, newSize / 2 - 1 + size - start, start);
            } else {
                System.arraycopy(items, 0, newItems, newSize / 2 - 1, size);
            }
            nextFirst = newSize / 2 - 2;
            nextLast = newSize - 1;
        } else {
            if (start < end) {
                System.arraycopy(items, start, newItems, newSize / 2 - 1, size);
            } else {
                System.arraycopy(items, start, newItems, newSize / 2 - 1, items.length - start);
                System.arraycopy(items, 0, newItems, newSize / 2 - 1 + items.length - start,
                        end + 1);
            }
            nextFirst = newSize / 2 - 2;
            nextLast = newSize - 1;
        }
        items = newItems;
    }

    @Override
    public void printDeque() {
        int current = addOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[current] + " ");
            current = addOne(current);
        }
        System.out.println();
    }

}
