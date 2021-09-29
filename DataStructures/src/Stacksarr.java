public class Stacksarr {
    String[] arr;
    int i = 0;

    public Stacksarr(int n){
        arr = new String[n];
    }

    public void push(String val){
        arr[i] = val;
        i += 1;
    }

    public void pop(){
        i -= 1;
        arr[i] = null;
    }

    public void printList(){
        for(String ar: arr){
            System.out.print(ar + " -> ");
        }
    }

    public static void main(String[] args) {
        Stacksarr inst = new Stacksarr(10);
        inst.push("Babu");
        inst.push("Babud");
        inst.printList();
    }
}
