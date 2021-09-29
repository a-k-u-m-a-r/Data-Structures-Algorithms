public class Queue {
    Node head, tail;

    public Queue(){
        
    }

    public void enqueue(int val){
        if(head == null && tail == null){
            head = new Node(val);
            tail = head;
        } 
        else{
            tail.next = new Node(val);
            tail = tail.next;
        }
        
    }

    public void dequeue(){
        if(head == null && tail == null){
            return;
        }
        head = head.next;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.val + " <- ");
            current = current.next;
        }
        // System.out.println("null");
    }

    public static void main(String[] args) {
        Queue inst = new Queue();
        inst.enqueue(5);
        inst.enqueue(7);
        inst.enqueue(10);
        inst.printList();
    }

}
