package fibonacci;

public class main {
    public static void main(String[] args) {
      int n = 2;
      int fibonacci = fibonacci(n);
      System.out.println(fibonacci);
    }
    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
