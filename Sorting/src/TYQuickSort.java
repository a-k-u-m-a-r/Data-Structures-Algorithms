public class TYQuickSort {
    
    public static void sort(Comparable[] arr, int lo, int hi){
        if(lo >= hi){return;}
        int i = lo;
        int lt = lo;
        int qt = hi;

        while(i <= qt){
            if(less(arr[i], arr[lt])){ // breaks -> v < arr[i]
                swap(arr, i, lt);
                i++;
                lt++;
            } else if(less(arr[lt], arr[i])){ // changed from arr[lt], arr[qt] -> arr[i] < v
                swap(arr, i, qt);
                qt--;
            } else{
                i++;
            }
        }
        sort(arr, lo, lt - 1);
        sort(arr, qt+1, hi);
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printList(Comparable[] a){
        for(Comparable x: a){
            System.out.print(x + ",");    
        }
    }

    public static void main(String[] args) {
        Integer[] a = {8,2,6,1,3,4,2,2,4,8,9};
        sort(a, 0, a.length-1);
        printList(a);
    }

}
