public class Shellsort{
   
    public Comparable[] sort(Comparable[] a){
        int h = 0;
        int counts = 0;

        while(h < a.length/3){
            h = 3 * h + 1;
            counts++;
        }

        while(h > 0){
            for(int i = h; i < a.length; i++){
                for(int j = i; j > 0; j-=h){
                    if((j - h) >= 0 && less(a[j], a[j - h])){
                        swap(a, j, j - h);
                    }
                }
            }
            h = (h - 1)/3;  
        }

        return a;
    }

    public boolean less(Comparable a, Comparable b){
        return a.compareTo(b) == -1;
    }

    public static void swap(Comparable[] a, int pos, int pos2){
        Comparable copy = a[pos];   
        a[pos] = a[pos2];
        a[pos2] = copy;
    }

    public boolean isOrdered(Comparable[] a){
        for(int i = 1; i < a.length - 1; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }

    public void printList(Comparable[] a){
        for(Comparable x: a){
            System.out.print(x + ",");    
        }
    }

    public static void main(String[] args) {
        Shellsort inst = new Shellsort();
        Integer[] abc = {1,2,3,78,2,1,5};
        inst.printList(inst.sort(abc));
    }
}

