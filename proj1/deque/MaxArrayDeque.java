package deque;

import java.util.Comparator;

public class MaxArrayDeque<AnyType> extends ArrayDeque<AnyType> {
    private Comparator<AnyType> cmp;

    public MaxArrayDeque(Comparator<AnyType> c) {
        size = 0;
        items = (AnyType[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        this.cmp = c;
    }

    /**
     * returns the maximum element in the deque as governed by the previously given Comparator.
     * If the MaxArrayDeque is empty, simply return null.
     */
    public AnyType max(Comparator<AnyType> c) {
        if (isEmpty()) {
            return null;
        }
        int maxIndex = 0;
        for (int i = 1; i < size(); i++) {
            if (c.compare(get(i), get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }
        return get(maxIndex);
    }

    public AnyType max() {
        return max(cmp);
    }




}
