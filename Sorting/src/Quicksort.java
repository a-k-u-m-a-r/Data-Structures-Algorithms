
public class Quicksort{

    public static int partition(Comparable[] arr, int lo, int hi){
        int i = lo;
        int j = hi+1;

        while(true){
            while(less(arr[++i], arr[lo])){
                if(i == hi){
                    break;
                }
            }

            while(less(arr[lo], arr[--j])){
                if(j == lo){
                    break;
                }
            }

            if(i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, lo, j);
        return j;


    }

    public static void sort(Comparable[] arr, int i, int j){
        if(j <= i) return;
        int p = partition(arr, i, j);
        sort(arr, i, p-1);
        sort(arr, p+1, j);
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0; 
    } 

    public static void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printList(Comparable[] a){
        for(Comparable x: a){
            System.out.print(x + ",");    
        }
    }

    public static void main(String[] args) {
        Integer[] x = {5,1,2,3,78,2,1,5};
        sort(x, 0, 7);
        printList(x);
    }

}