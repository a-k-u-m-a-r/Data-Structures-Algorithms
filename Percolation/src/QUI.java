public class QUI {
    private int[] arr;
    private int[] sz;

    public QUI(int n){
        arr = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int n){
        while(n != arr[n]){
            arr[n] = arr[arr[n]]; // path compression
            n = arr[n];
        }
        return n;
    }

    public void union(int p, int q){
        int pr = root(p);
        int qr = root(q);

        if(sz[pr] > sz[qr]){
            arr[qr] = arr[pr];
            sz[pr] += sz[qr];
        }
        else{
            arr[pr] = arr[qr];
            sz[qr] += sz[pr];
        }
    }

    public boolean connected(int p, int q){
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
        QUI q = new QUI(10);
        q.union(5, 4);
        q.union(6, 5);
        q.union(3, 5);

        q.union(2, 1);
        q.union(0, 1);
        q.union(0, 3);
        q.getArr();
        System.out.println(q.connected(4, 6));
    }
}
