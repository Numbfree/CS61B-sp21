package deque;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            ad1.addFirst(i);
            ad1.printArray();
        }
    }

    /**
     * Test addLast function and resize function;
     */
    @Test
    public void addLastTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
            ad1.printArray();
        }
    }


    @Test
    public void removeFirstTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
            ad1.printArray();
        }

        for (int i = 0; i < 10; i++) {
            ad1.removeFirst();
            ad1.printArray();
        }
    }

    @Test
    public void removeLastTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
            ad1.printArray();
        }

        for (int i = 0; i < 10; i++) {
            ad1.removeLast();
            ad1.printArray();
        }
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 400; i++) {
            ad1.addLast(i);
        }
        ad1.printArray();
        assertEquals("Should have the same value", 305, (double) ad1.get(305), 0.0);

    }
}
