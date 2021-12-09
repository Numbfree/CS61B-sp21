package deque;

public interface Deque<AnyType>{
    public void addFirst(AnyType item);
    public void addLast(AnyType item);

    default public boolean isEmpty() {
        return size() == 0;
    }

    public int size();
    public void printDeque();
    public AnyType removeFirst();
    public AnyType removeLast();
    public AnyType get(int index);
}
