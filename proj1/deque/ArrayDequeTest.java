package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    /** Adds a few things to the Alist, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {


        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Test if the reSize function works properly for both upSize and downSize. */

    public void reSizeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        for (int i = 0; i < 15; i += 1) {
            lld1.addLast(i);
        }


        assertEquals(16, lld1.arrayLength(), 0);

        for (int i = 0; i < 14; i += 1) {
            lld1.removeLast();
        }
        assertEquals(8, lld1.arrayLength(), 0);

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

        assertEquals("string", s);
        assertEquals(3.14159, d, 0);
        assertEquals(true, b);

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add small number of elements to deque; check if order is correct. */
    public void smallLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 5; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 2; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 4; i > 2; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    @Test
    /* Add 8 elements and test if the upsize function works propertly. */
    public void upSizeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 8; i++) {
            ad1.addLast(i);
        }
        assertEquals(" Should have the size as expected: 16", 16.0, (double) ad1.arrayLength(), 0.0);

        for (int i = 8; i < 16; i++) {
            ad1.addFirst(i);
        }
        assertEquals(" Should have the size as expected: 32", 32.0, (double) ad1.arrayLength(), 0.0);

    }

    @Test
    /* Add 8 elements and then remove 4, test if the downSize() works propertly. */
    public void downSizeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 8; i++) {
            ad1.addLast(i);
            ad1.printWholeDeque();
        }
        assertEquals(" Should have the size as expected: 16", 16.0, (double) ad1.arrayLength(), 0.0);

        for (int i = 0; i < 5; i++) {
            ad1.removeFirst();
            ad1.printWholeDeque();
        }
        assertEquals(" Should have the size as expected: 32", 8.0, (double) ad1.arrayLength(), 0.0);
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }
}

