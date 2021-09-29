public class PriorityQueue<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N;

    public PriorityQueue(int N){
        pq = (Key[]) new Comparable[N + 1];
        this.N = N+1;
    }

    public PriorityQueue(Key[] arr){
        pq = (Key[]) new Comparable[arr.length + 10]; // should be 1, not using resizing array
        N = arr.length - 1; // kinda sketch
        for(int i = 1; i < arr.length; i++){
            pq[i] = arr[i];
        }
    }

    public void insert(Key val){
        pq[++N] = val;
        swim(N);
        // swim
    }

    public void delMax(){
        Key max = pq[1];
        swap(1, N);
        pq[N--] = null;
        sink(1);
    }

    public Key max(){
        return pq[1];
    }

    public void swim(int c){
        while (c > 1 && less(c/2, c)){
            swap(c/2, c);
            c/=2;
        }
    }

    public void sink(int p){ // if both children are bigger than the parent
        while(2*p + 1 <= N){
            if(less(2*p, 2*p+1) && less(p, 2*p+1)){ // find the bigger child and checks if parent is smaller than child
                swap(p, 2*p+1); // swap parent and child
                p = 2*p + 1; // reset parent index
            } else{
                if(less(2*p, p)){break;}
                swap(p, 2*p);
                p*=2;
            }
        }
         
    }

    public void swap(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void printPQ(){
        int n = 1;
        int s = 1;
        int j = 3;

        int l = (int) (Math.log(pq.length)/ Math.log(2));
        System.out.println(l);

        for(int i = 1; i < pq.length; i++){
            if(pq[i] != null){
                if(s == i){
                    System.out.print(spaces(4 * l));
                    s *=2;
                }
                if(j == i){
                    System.out.print(spaces(2 * (l) + 1));
                    j+=2;
                }
                if(n == i){
                    System.out.println(pq[i]);
                    n = 2 * n + 1;
                    l--;
                } else{
                    System.out.print(pq[i] + " - ");
                }
                
            }
        }
        System.out.println();
    }

    public String spaces(int n){
        String s = "";
        for(int i = 0; i < n; i++){
            s += " ";
        }
        return s;
    }

    public static void main(String[] args) {
        Integer[] x = {0,10,9,8,7,6,5,4,3,2,1};
        PriorityQueue<Integer> p = new PriorityQueue<Integer>(x);
        p.printPQ();
    }

}


