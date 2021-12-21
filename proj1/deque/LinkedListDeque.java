package deque;

import java.util.Iterator;

public class LinkedListDeque<AnyType> {
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
    public void addLast(AnyType x) {
        Node temp = new Node(sentinel.prev, x, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the size of linked list deque
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
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
