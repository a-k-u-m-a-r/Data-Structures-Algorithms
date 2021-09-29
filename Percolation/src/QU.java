public class QU {
    private int[] arr;

    public QU(int n){
        arr = new int[n];
        for(int r = 0; r < n; r++){
            arr[r] = r;
        }
    }

    public int root(int n){
        while(arr[n] != n){
            n = arr[n];
        }
        return n;
    }

    public void union(int p, int q){
        int pr = root(p);
        int qr = root(q);

        arr[pr] = qr;
    }

    public boolean find(int p, int q){
        return root(p) == root(q);
    }

    public void getArr(){
        System.out.print("[");
        for(int x: arr){
            System.out.print(x + ",");
        }
        System.out.print("]");
    }


    public static void main(String[] args){
        QU q = new QU(10);
        q.union(5, 4);
        q.union(6, 5);
        q.union(3, 5);
        q.getArr();
        System.out.println(q.find(4, 6));
    }
}
