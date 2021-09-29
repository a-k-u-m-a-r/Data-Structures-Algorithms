import java.util.Random;

public class ShuffleSort {
    
    public void shuffle(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            Comparable temp = arr[i];
            int r = (int)(Math.random() * (i + 1));
            arr[i] = arr[r];
            arr[r] = temp;
        }    
    }

    public static void swap(Comparable[] a, int pos, int pos2){
        Comparable copy = a[pos];   
        a[pos] = a[pos2];
        a[pos2] = copy;
    }

    public void printList(Comparable[] a){
        for(Comparable x: a){
            System.out.print(x + ",");    
        }
    }
}
