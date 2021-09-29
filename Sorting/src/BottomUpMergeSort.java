public class BottomUpMergeSort {
    

    public static void sort(Comparable[] arr){
        int set = 2;

        while(set <= arr.length){
            for(int i = 0; i < arr.length; i+=set){
                int mid = i + (set-1)/2;
                merge(arr, i, mid, i+(set-1));
            }
            set *= 2;
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) <= 0;
    }

    public static void merge(Comparable[] arr, int lo, int mi, int hi){
        Comparable[] aux = new Comparable[arr.length];

        int lp = lo; // pointer for lo side - left
        int mp = mi + 1; // pointer for hi side - right

        for(int i = lo; i <= hi; i++){
            aux[i] = arr[i];
        }

        for(int j = lo; j <= hi; j++){
            if(lp > mi){
                arr[j] = aux[mp++];
            }
            else if(mp > hi){
                arr[j] = aux[lp++];
            }
            else if(less(aux[lp], aux[mp])){
                arr[j] = aux[lp++];
            }
            else{
                arr[j] = aux[mp++];
            }
        }
    }

    public static void printList(Comparable[] a){
        for(Comparable x: a){
            System.out.print(x + ",");    
        }
    }

    public static void main(String[] args) {
        BottomUpMergeSort inst = new BottomUpMergeSort();
        Integer[] x = {5,1,2,3,78,2,1,5};
        sort(x);
        printList(x);
    }
}
