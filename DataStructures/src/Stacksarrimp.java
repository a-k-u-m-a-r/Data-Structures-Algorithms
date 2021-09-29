public class Stacksarrimp {
    String[] arr;
    int pos = 0;

    public Stacksarrimp(){
        arr = new String[1];
    }

    public void push(String val){
        if(pos == arr.length){
            String[] copy = new String[arr.length * 2];
            for(int i = 0; i < arr.length; i++){
                copy[i] = arr[i];
            }
            arr = copy;
        }
        arr[pos] = val;
        pos += 1;
    }

    public void pop(){
        pos -= 1;
        arr[pos] = null;

        if(pos == arr.length/4){
            String[] copy = new String[arr.length / 2];
            for(int i = 0; i < copy.length; i++){
                copy[i] = arr[i];
            }
            arr = copy;
        }
    }

    public void printList(){
        System.out.println("Array Length: " + arr.length);
        for(String ar: arr){
            System.out.print(ar + " -> ");
        }
    }

    public static void main(String[] args) {
        Stacksarrimp inst = new Stacksarrimp();
        inst.push("Babu");
        inst.push("Babud");
        inst.push("Babud");
        inst.push("Babud");
        inst.push("Babud");
        inst.pop();
        inst.pop();
        inst.pop();
        inst.pop();
        inst.pop();
        inst.printList();
    }
}
