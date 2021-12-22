package deque;

import java.util.Iterator;
import java.util.Objects;

public class ArrayDeque<AnyType> implements Deque<AnyType>, Iterable<AnyType> {
    protected AnyType[] items;
    protected int size;
    protected int nextFirst;
    protected int nextLast;
    protected double Faction = 0.25;


    public ArrayDeque() {
        items = (AnyType[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public ArrayDeque (AnyType item) {
        items = (AnyType[]) new Object[8];
        items[0] = item;
        size = 1;
        nextFirst = 2;
        nextLast = 4;
    }

    @Override
    public void addFirst(AnyType item) {
        if (size == items.length) {
            this.resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    @Override
    public void addLast(AnyType item) {
        if (size == items.length) {
            this.resize(size * 2);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = addOne(nextLast);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public AnyType removeFirst() {
        if (size == 0) {
            return null;
        }

        if ((double) size / items.length == Faction && items.length > 8) {
            resize(items.length / 2);
        }

        nextFirst = addOne(nextFirst);
        AnyType item = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return item;
    }

    @Override
    public AnyType removeLast() {
        if (size == 0) {
            return null;
        }

        if ((double) size / items.length == Faction && items.length > 8) {
            resize(items.length / 2);
        }

        nextLast = minusOne(nextLast);
        AnyType item = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return item;
    }

    @Override
    public AnyType get(int index) {
        if (size <= index || index < 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    public Iterator<AnyType> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<AnyType> {
        private int currentIndex;

        ArrayDequeIterator() {
            currentIndex = 0;
        }

        public boolean hasNext() {
            return currentIndex < size;
        }

        public AnyType next() {
            AnyType item = get(currentIndex);
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
        ArrayDeque<?> ad = (ArrayDeque<?>) o;
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
        if (number + 1 > items.length -1) {
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
        AnyType[] newItems = (AnyType[]) new Object[newSize];
        int start = addOne(nextFirst);
        int end = minusOne(nextLast);

        if (newSize > items.length) {
            if (end < start) {
                System.arraycopy(items, start, newItems, newSize / 2 - 1, size - start);
                System.arraycopy(items, 0, newItems, newSize / 2 - 1 + size - start, start);
            }else {
                System.arraycopy(items, 0, newItems, newSize / 2 - 1, size);
            }
            nextFirst = newSize / 2 - 2;
            nextLast = newSize - 1;
        }else {
            if (start < end) {
                System.arraycopy(items, start, newItems, newSize / 2 - 1, size);
            }else {
                System.arraycopy(items, start, newItems, newSize / 2 - 1, items.length - start);
                System.arraycopy(items, 0, newItems, newSize / 2 - 1 + items.length - start, end + 1);
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

    public void printArray() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                System.out.print("n" + " ");
            }else {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }

}
