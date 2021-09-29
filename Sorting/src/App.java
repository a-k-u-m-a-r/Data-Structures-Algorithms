public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(multiply(5));
    }

    public static int multiply(int n){
        if(n == 0){
            return 1;
        } else{
            return n * multiply(n-1);
        }
    }
}
