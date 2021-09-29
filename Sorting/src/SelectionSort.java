public class SelectionSort {
    
    public Comparable[] sort(Comparable[] a){
        

        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a.length; j++){
                int min = i;
                if(less(a[j], a[min])){
                    swap(a, min, j);    
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
        SelectionSort inst = new SelectionSort();
        Integer[] abc = {5,1,2,3,78,2,1,5};
        inst.printList(inst.sort(abc));
    }

}
