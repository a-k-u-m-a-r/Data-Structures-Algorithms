public class Stacks {
    Node head;

    public void push(int n){
        Node oldhead = head;
        head = new Node(n);
        head.next = oldhead;
    }

    public void pop(){
        head = head.next;
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
        Stacks inst = new Stacks();
        inst.push(1);
        inst.push(2);
        inst.push(3);
        inst.push(4);
        inst.push(5);
        inst.pop();
        inst.printList();
    }

}

// class Node{
//     Node next;
//     int val;

//     public Node(int val){
//         this.val = val;
//     }
// }