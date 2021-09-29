import java.util.Iterator;

public class GenStack<T> implements Iterable<T>{
    GenNode<T> head;

    public void push(T val){
        GenNode<T> oldHead = head;
        head = new GenNode(val);
        head.next = oldHead;
    }

    public void pop(){
        if(head == null){
            return;
        }
        head = head.next;
    }

    @Override
    public Iterator iterator() {
        return new StackIter();
    }

    class StackIter implements Iterator<T>{

        private GenNode<T> current = head;
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }
    
        @Override
        public T next() {
            // TODO Auto-generated method stub
            T val = current.val;
            current = current.next;
            return val;
        }
        
    }

    public static void main(String[] args) {
        GenStack<String> inst = new GenStack<>();
        inst.push("My");
        inst.push("Name");
        inst.push("Is");
        inst.push("Akshay");
        inst.push("Kumar");

        for( String item: inst){
            System.out.print(item + " -> ");
        }
        
    }
}

class GenNode<T>{
    GenNode<T> next;
    T val;

    public GenNode(T val){
        this.val = val;
    }
}

