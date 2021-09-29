public class UF {
    private int[] arr;
    // private int openSites;
    public UF(int n){
        arr = new int[n];
        for(int r = 0; r < n; r++){
            arr[r] = r;
        }
    }

    public boolean connected(int p, int q){
        return arr[p] == arr[q];
    }

    public void union(int p, int q){
        int pid = arr[p];
        int qid = arr[q];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == pid){
                arr[i] = qid;
            }
        }
    }

    public void getArr(){
        System.out.print("[");
        for(int x: arr){
            System.out.print(x + ",");
        }
        System.out.print("]");
    }

    public static void main(String[] args){
        UF f = new UF(10);

        f.union(0, 1);
        f.getArr();
    }
}
