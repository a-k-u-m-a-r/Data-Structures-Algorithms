public class ThreeWayQuickSort {
    
    public static int partition(Comparable[] arr, int lo, int hi){
        int i = lo + 1;
        int lt = lo;
        int gt = hi;

        while(true){
            while(arr[i].equals(arr[lt])){
                i++;
            }

            while(less(arr[i], arr[lt])){
                if(i >= hi){break;}
                swap(arr, i, lt);
                if(arr[i] != arr[lt]){ lt++;}
                i++;
            }

            while(less(arr[lt], arr[--gt])){
                if(gt <= lo){break;}
            }

            if(i >= gt){break;}
            swap(arr, i, gt);
        }

        return i;

    }

    public static void printList(Comparable[] a){
        for(Comparable x: a){
            System.out.print(x + ",");    
        }
    }

    public static void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void sort(Comparable[] arr, int i, int j){
        if(j <= i) return;
        int p = partition(arr, i, j);
        sort(arr, i, p-1);
        sort(arr, p+1, j);
    }

    public static void main(String[] args) {
        ThreeWayQuickSort q = new ThreeWayQuickSort();
        Integer[] a = {8,2,6,1,3,4,2,2,4,8,9};
        Integer[] b = {2,6,1,3,4,2,2,4};
        sort(a, 0, a.length-1);
        printList(a);
    }
}
