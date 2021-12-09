package deque;
import java.util.Comparator;

public class MaxArrayDeque<AnyType> extends ArrayDeque<AnyType> {
    private Comparator<AnyType> comp;

    public MaxArrayDeque(Comparator<AnyType> c) {
        comp = c;
    }

    public AnyType max() {
        if (this.isEmpty()){
            return null;
        }

        int maxDex = 0;
        for (int i = 1; i < size(); i ++){
            AnyType maxValue = get(maxDex);
            AnyType current = get(i);
            if (comp.compare( maxValue,current) < 0){
                maxDex = i;
            }
        }
        return this.get(maxDex);
    }

    public AnyType max(Comparator<AnyType> c) {
        if (this.isEmpty()){
            return null;
        }

        comp = c;
        int maxDex = 0;
        for (int i = 1; i < size(); i ++){
            AnyType maxValue = get(maxDex);
            AnyType current = get(i);
            if (comp.compare( maxValue,current) < 0){
                maxDex = i;
            }
        }
        return this.get(maxDex);
    }

}
