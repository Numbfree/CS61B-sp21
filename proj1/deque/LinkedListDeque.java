package deque;
import java.util.Iterator;
public class LinkedListDeque<AnyType> implements Deque<AnyType> {

    public class ItemNode {
        public ItemNode prev;
        public AnyType item;
        public ItemNode next;

        public ItemNode(ItemNode p, AnyType i, ItemNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private ItemNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new ItemNode(sentinel, null, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(AnyType x){
        sentinel = new ItemNode(sentinel, null, sentinel);
        ItemNode target = new ItemNode(sentinel, x, sentinel);
        sentinel.next = target;
        sentinel.prev = target;
        size = 1;
    }

    @Override
    public void addFirst(AnyType x){
        ItemNode target = new ItemNode(sentinel, x, sentinel.next);
        sentinel.next.prev = target;
        sentinel.next = target;
        size += 1;
    }

    @Override
    public void addLast(AnyType x){
        ItemNode target = new ItemNode(sentinel.prev, x, sentinel);
        sentinel.prev.next = target;
        sentinel.prev = target;
        size += 1;
    }


    @Override
    public int size(){
        return this.size;
    }

    @Override
    public void printDeque(){
        ItemNode print = sentinel.next;
        int i = this.size();
        while (i > 0){
            System.out.print(print.item);
            System.out.print(" ");
            print = print.next;
            i -= 1;
        }
        System.out.println("");

    }

    @Override
    public AnyType removeFirst(){
        if (size == 0){
            return null;
        }
        AnyType targetItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return targetItem;
    }

    @Override
    public AnyType removeLast(){
        if (size == 0){
            return null;
        }
        AnyType targetItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return targetItem;
    }

    @Override
    public AnyType get(int index){
        if (index > size || index < 0){
            return null;
        }
        ItemNode current = sentinel.next;
        while (index > 0){
            current = current.next;
        }
        return current.item;
    }


    public AnyType getRecursive(int index){
        if (index > size || index < 0){
            return null;
        }
        return getRecursive(this.sentinel.next, index);
    }

    private AnyType getRecursive(ItemNode n, int i){
        if (i == 0){
            return n.item;
        }
        return getRecursive(n.next,i-1);
    }

    public Iterator<AnyType> iterator() {
        return iterator();
    }

    public boolean equals(Object o) {
        boolean preRequsite = o instanceof LinkedListDeque;
        if (preRequsite){
            return false;
        }
        LinkedListDeque<AnyType> newO = (LinkedListDeque<AnyType>) o;

        for (int i = 0; i < size(); i++){
            if (get(i) != newO.get(i)){
                return false;
            }
        }
        return true;
    }



}
