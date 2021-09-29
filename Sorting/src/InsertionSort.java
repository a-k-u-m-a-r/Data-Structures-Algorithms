public class InsertionSort {
    
    public static Comparable[] sort(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0; j--){
                if(less(a[j], a[j-1])){
                    swap(a, j, j - 1);
                }
            }
        }
        return a;
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void printList(Comparable[] a){
        for(Comparable x: a){
            System.out.print(x + ",");    
        }
    }

    public static void main(String[] args) {
        InsertionSort inst = new InsertionSort();
        Integer[] abc = {5,1,2,3,78,2,1,5};
        inst.printList(inst.sort(abc));
    }

}
