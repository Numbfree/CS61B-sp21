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

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", ad1.isEmpty());

    }

    @Test
    public void equalTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();

        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);

        ad2.addLast(1);
        ad2.addLast(2);
        ad2.addLast(3);
        assertTrue("ad1 should equal to ad2", ad1.equals(ad2));




    }
}
