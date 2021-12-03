package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> al1 = new AListNoResizing<Integer>();
        BuggyAList<Integer> al2 = new BuggyAList<Integer>();

        for (int i = 4; i < 7; i++) {
            al1.addLast(i);
            al2.addLast(i);
            assertEquals(al1.getLast(), al2.getLast(), 0);
        }

        for (int i = 4; i < 7; i++) {
            assertEquals(al1.removeLast(),al2.removeLast(), 0);
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> H = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                H.addLast(randVal);
                L.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                assertEquals(H.size(), L.size(), 0);
                int size = L.size();
            } else if (operationNumber == 2){
                if (L.size() > 0) {
                    //getLast
                    assertEquals(H.getLast(), L.getLast(), 0);
                }
            } else if (operationNumber == 3){
                if (L.size() > 0){
                    //removeLast
                    int everyLast = L.removeLast();
                    assertEquals(H.removeLast(), everyLast, 0);
                }
            }

        }
    }
}