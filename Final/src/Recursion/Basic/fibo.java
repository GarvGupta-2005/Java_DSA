package Recursion.Basic;

public class fibo {
    public static int nthFibo(int n){
        if(n==0 || n == 1){
            return n;
        }
        return nthFibo(n-1) +  nthFibo(n-2);
    }
}
