package deque;
import java.util.Iterator;
public class ArrayDeque<AnyType> implements Deque<AnyType> {

    private AnyType[] items;
    private int nextFirst = 0;
    private int nextLast = 0;
    private int size;
    private int REFACTOR = 2;
    private double FILLFRACTION = 0.25;

    public ArrayDeque() {
        items = (AnyType[]) new Object[8];
        size  = 0;
    }
    /* check the size of array every time before add/remove. */
    public void upSize() {
         if (size == items.length) {
            if (nextFirst < nextLast) {
               AnyType[] newArray = (AnyType[]) new Object[size * REFACTOR];
               System.arraycopy(items, nextFirst+1, newArray, 0, items.length-nextFirst-1);
               System.arraycopy(items, 0, newArray, items.length-nextFirst-1, nextFirst+1);
               items = newArray;
               nextFirst = items.length - 1;
               nextLast = size;
               newArray = null;
               return;
           }else {
               AnyType[] NewArray = (AnyType[]) new Object[size * REFACTOR];
               System.arraycopy(items, 0, NewArray, 0, size);
               items = NewArray;
               nextFirst = items.length - 1;
               nextLast = size;
               NewArray = null;
               return;
           }
       }
    }

    public void downSize() {
        if ((double) size/items.length < FILLFRACTION && items.length > 8){
            int begin  = checkCircular(nextFirst+1);
            int end = checkCircular(nextLast-1);

            if (begin < end){
                AnyType[] NewArray = (AnyType[]) new Object[items.length/2];
                System.arraycopy(items, begin, NewArray, 0, size);
                items = NewArray;
                nextFirst = items.length - 1;
                nextLast = size;
                NewArray = null;
                return;
            }else {
                AnyType[] NewArray = (AnyType[]) new Object[items.length/2];
                System.arraycopy(items, begin, NewArray, 0, items.length-1);
                System.arraycopy(items, 0, NewArray, items.length-begin, end);
                items = NewArray;
                nextFirst = items.length - 1;
                nextLast = size;
                NewArray = null;
                return;
            }
        }
    }

    /* Function to get the current array size rather than the real deque size. */
    public int arrayLength() {
        return items.length;
    }

    /* convert the position from nextFirst/Last to real begin/end. */
    public int checkCircular (int x){
        if (x < 0) {
            return items.length-1;
        } else if (x > items.length - 1) {
            return 0;
        } else {
            return x;
        }
    }

    @Override
    public void addFirst(AnyType x) {
        items[nextFirst] = x;
        if (nextFirst == nextLast){
            nextLast = checkCircular(nextLast + 1);
        }
        nextFirst = checkCircular(nextFirst - 1);
        size += 1;
        this.upSize();
    }

    @Override
    public void addLast(AnyType x) {
        items[nextLast] = x;
        if (nextFirst == nextLast){
            nextFirst = checkCircular(nextFirst - 1);
        }
        nextLast = checkCircular(nextLast + 1);
        size += 1;
        this.upSize();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int begin  = checkCircular(nextFirst+1);
        int end = checkCircular(nextLast-1);

        if (begin > end) {
            for (int i = begin; i < items.length; i += 1){
                System.out.print(items[i] + "");
            }
            for (int i = 0; i < end; i += 1){
                System.out.print(items[i] + "");
            }
            System.out.println("");
            return;
        }
        for (int i = begin; i < nextLast; i += 1){
            System.out.print(items[i] + "");
        }
        System.out.println("");
    }

    /** The function to print whole Deque. Convenient for the test.
    public void printWholeDeque(){
        for (int i = 0; i < items.length; i++){
            if (items[i] == null){
                System.out.print("null");
            }else{
                System.out.print(items[i]);
            }
            System.out.print("->");
        }
        System.out.println("");
    }
     */

    @Override
    public AnyType removeFirst() {
        if (size == 0) {
            return null;
        }
        AnyType first = items[checkCircular(nextFirst + 1)];
        items[checkCircular(nextFirst + 1)] = null;
        nextFirst = checkCircular(nextFirst + 1);
        size -= 1;
        this.downSize();
        return first;
    }

    @Override
    public AnyType removeLast() {
        if (size == 0) {
            return null;
        }
        AnyType last = items[checkCircular(nextLast - 1)];
        items[checkCircular(nextLast - 1)] = null;
        nextLast = checkCircular(nextLast - 1);
        size -= 1;
        this.downSize();
        return last;
    }

    @Override
    public AnyType get(int index) {
        int truePosition = nextFirst + index + 1;
        if ( truePosition > items.length - 1){
            truePosition = truePosition - items.length;
        }
        if (items[truePosition] == null) {
            return null;
        }
        return items[truePosition];
    }

    public Iterator<AnyType> iterator() {
        return iterator();
    }

    public boolean equals(Object o) {
        return o instanceof Deque;
    }

}
