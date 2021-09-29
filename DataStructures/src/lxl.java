public class lxl {
    Node head;

    public void append(int n){
        if(head == null){
            head = new Node(n);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(n);
    }

    public void preappend(int n){
        if(head == null){
            head = new Node(n);
        }
        Node oldHead = head;
        head = new Node(n);
        head.next = oldHead;
    }

    public void deleteNode(int val){
        if(head == null){
            return;
        }
        if(head.val == val){
            head = head.next;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.val != val){
                current = current.next;
            } else{
                current.next = current.next.next;
                return;
            }
        }
        
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        lxl inst = new lxl();
        inst.append(1);
        inst.append(2);
        inst.append(3);
        inst.append(4);
        inst.append(5);
        inst.deleteNode(3);
        inst.preappend(0);
        inst.deleteNode(2);
        inst.deleteNode(0);
        inst.printList();
    }
}

class Node{
    Node next;
    int val;

    public Node(int val){
        this.val = val;
    }
}

