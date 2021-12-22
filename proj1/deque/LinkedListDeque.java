package deque;

import java.util.Iterator;

public class LinkedListDeque<AnyType> implements Deque<AnyType>, Iterable<AnyType> {
    private class Node {
        private Node prev;
        private AnyType item;
        private Node next;

        Node() {
            prev = null;
            item = null;
            next = null;
        }

        Node(Node p, AnyType x, Node n) {
            prev = p;
            item = x;
            next = n;
        }
    }

    private int size;
    private Node sentinel;

    /**
     * Creates an empty linked list deque
     */
    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Creates a linked list deque with item x;
     */
    public LinkedListDeque(AnyType x) {
        sentinel.next = new Node(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /**
     * Adds an item of type AnyType to the front of the deque.
     * You can assume that item is never null.
     */
    @Override
    public void addFirst(AnyType x) {
        Node temp = new Node(sentinel, x, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size += 1;
    }

    /**
     * Adds an item of type AnyType to the end of the deque.
     * You can assume that item is never null.
     */
    @Override
    public void addLast(AnyType x) {
        Node temp = new Node(sentinel.prev, x, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size += 1;
    }

    public Iterator<AnyType> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<AnyType> {
        private Node currentNode;

        LinkedListDequeIterator() {
            currentNode = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return currentNode != sentinel;
        }

        @Override
        public AnyType next() {
            AnyType item = currentNode.item;
            currentNode = currentNode.next;
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
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque<?> lld = (LinkedListDeque<?>) o;
        if (lld.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (lld.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the size of linked list deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    @Override
    public void printDeque() {
        Node temp = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.next.item + " ");
        }
        System.out.println();
    }

    /**
     *  Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    @Override
    public AnyType removeFirst() {
        if (isEmpty()) {
            return null;
        }
        AnyType temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return temp;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    @Override
    public AnyType removeLast() {
        if (isEmpty()) {
            return null;
        }
        AnyType temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return temp;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    @Override
    public AnyType get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Node temp = sentinel;
        for (int i = 0; i <= index; i++) {
            temp = sentinel.next;
        }
        return temp.item;
    }

    /**
     * Same as get, but uses recursion.
     */
    public AnyType getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private AnyType getRecursiveHelper(int index, Node currentNode) {
        if (index == 0) {
            return currentNode.item;
        }
        return getRecursiveHelper(index - 1, currentNode.next);
    }



}
