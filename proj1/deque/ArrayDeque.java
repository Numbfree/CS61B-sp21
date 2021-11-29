package deque;


public class ArrayDeque<AnyType> {

    private AnyType[] items;
    private int nextFirst = 0;
    private int nextLast = 1;
    private int size;
    private int REFACTOR = 2;
    private double FILLFRACTION = 0.25;

    public ArrayDeque(){
        items = (AnyType[]) new Object[8];
        size  = 0;
    }
    /* check the size of array every time before add/remove. */
    public void reSize() {
        if (items.length == size && size != 0) {
            AnyType[] NewArray = (AnyType[]) new Object[size * REFACTOR];
            System.arraycopy(NewArray, 0, items, nextFirst+1, size - 1);
            System.arraycopy(NewArray, size-1, items, 0, nextLast);
            items = NewArray;
            NewArray = null;
        } else if ((double) size/items.length < FILLFRACTION  && items.length > 8){
            AnyType[] NewArray = (AnyType[]) new Object[items.length/2];
            System.arraycopy(NewArray, 0, items, 0, size - 1);
            items = NewArray;
            NewArray = null;
        }
    }
    /* Function to tell the array size rather than the real deque size. */
    public int arrayLength() {
        return items.length;
    }

    public int checkCircular (int x){
        if (x < 0) {
            return items.length-1;
        } else if (x > items.length - 1) {
            return 0;
        } else {
            return x;
        }

    }


    public void addFirst(AnyType x) {
        this.reSize();
        items[nextFirst] = x;
        nextFirst = checkCircular(nextFirst - 1);
        size += 1;
    }

    public void addLast(AnyType x) {
        this.reSize();
        items[nextLast] = x;
        nextLast = checkCircular(nextLast + 1);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (nextFirst > nextLast) {
            for (int i = nextFirst + 1; i < items.length; i += 1){
                System.out.print(items[i] + "");
            }
            for (int i = 0; i < nextLast; i += 1){
                System.out.print(items[i] + "");
            }
            System.out.println("");
            return;
        }
        for (int i = nextFirst + 1; i < nextLast; i += 1){
            System.out.print(items[i] + "");
        }
        System.out.println("");
    }

    public AnyType removeFirst() {
        if (size == 0) {
            return null;
        }
        this.reSize();
        AnyType first = items[checkCircular(nextFirst + 1)];
        items[checkCircular(nextFirst + 1)] = null;
        nextFirst = checkCircular(nextFirst + 1);
        size -= 1;
        return first;
    }

    public AnyType removeLast() {
        if (size == 0) {
            return null;
        }
        this.reSize();
        AnyType last = items[checkCircular(nextLast - 1)];
        items[checkCircular(nextLast - 1)] = null;
        nextLast = checkCircular(nextLast - 1);
        size -= 1;
        return last;
    }

    public AnyType get(int index) {
        return items[index];
    }





}
