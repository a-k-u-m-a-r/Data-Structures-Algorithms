public class Percolation {
    private int[][] perc;
    private int openSites;
    public Percolation(int n){
        if(n < 1){
            throw new IllegalArgumentException();
        }
        perc = new int[n][n];
        openSites = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                perc[r][c] = 1;
            }
        }
    }

    public void open(int row, int col){
        if(row < 1 || col < 1){
            throw new IllegalArgumentException();
        }
        perc[row - 1][col - 1] = 0;
    }

    public boolean isOpen(int row, int col){
        if(row < 1 || col < 1){
            throw new IllegalArgumentException();
        }
        return perc[row - 1][col - 1] == 0;
    }
    
    public boolean isFull(int row, int col){
        if(row < 1 || col < 1){
            throw new IllegalArgumentException();
        }
        return perc[row - 1][col - 1] == 1;
    }

    public int numberOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        return false;
    }

    public static void main(String[] args){
        Percolation p = new Percolation(5);
    }
}
