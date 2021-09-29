import java.util.Comparator;

public class MergeSort {
    
    private static void merge(Comparable[] arr, Comparable[] aux, int s, int m, int e){


        int lo = s;
        int l2 = m + 1;

        for(int a = lo; a <= e; a++){
            aux[a] = arr[a];
        }

        for(int i = s; i <= e; i++){

            if(lo > m){
                arr[i] = aux[l2++];
            }
            else if(l2 > e){
                arr[i] = aux[lo++];
            }
            else if(less(aux[lo], aux[l2])){
                arr[i] = aux[lo++];
            }
            else{
                arr[i] = aux[l2++];
            }
            
        }

    }

    private static void mergeC(Comparator c, Comparable[] arr, Comparable[] aux, int s, int m, int e){


        int lo = s;
        int l2 = m + 1;

        for(int a = lo; a <= e; a++){
            aux[a] = arr[a];
        }

        for(int i = s; i <= e; i++){

            if(lo > m){
                arr[i] = aux[l2++];
            }
            else if(l2 > e){
                arr[i] = aux[lo++];
            }
            else if(lessC(c, aux[lo], aux[l2])){
                arr[i] = aux[lo++];
            }
            else{
                arr[i] = aux[l2++];
            }
            
        }

    }

    private static void sortC(Comparator c, Comparable[] arr, Comparable[] aux, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sortC(c, arr, aux, lo, mid);
        sortC(c, arr, aux, mid+1, hi);
        mergeC(c, arr, aux, lo, mid, hi);
    }

    public static void sortC(Comparator c, Integer[] arr){
        Integer[] aux = new Integer[arr.length];
        sortC(c, arr, aux, 0, arr.length-1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid+1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] arr){
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length-1);
    }

    public static boolean isOrdered(Comparable[] a, int lo, int hi){
        for(int i = lo; i < hi - 1; i++){
            if(less(a[i+1], a[i])){
                return false;
            }
        }
        return true;
    }
    
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) <= 0;
    }

    public static boolean lessC(Comparator c, Comparable a, Comparable b){
        return c.compare(a, b) <= 0;
    }

    public static void printList(Comparable[] a){
        for(Comparable x: a){
            System.out.print(x + ",");    
        }
    }

    public static void main(String[] args) {
        MergeSort inst = new MergeSort();
        Integer[] x = {5,1,21,13,78,2123,1111,523};
        
        sortC(new MergeSortComparer(), x);
        printList(x);

    }
}


class MergeSortComparer implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if ((int) o1.toString(o1).charAt(0) < (int) o2.toString(o2).charAt(0)){
            return -1;
        } else if((int) o1.toString(o1).charAt(0) == (int) o2.toString(o2).charAt(0)){
            return 0;
        } else{
            return 1;
        }
        
    }
    
}

