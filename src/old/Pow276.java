package old;

/**
 * Created by parallel on 9/16/16.
 */
public class Pow276 {
    /**
     * Problem:
     * Implement pow(x, n).
     * This is a great example to illustrate how to solve a problem during a technical
     * interview. The first and second solution exceeds time limit; the third and fourth are
     * accepted.
     * @param args
     */
    public static void main(String[] args){
//        test
        System.out.println(pow(2,2));
        System.out.println(pow(2,-2));
        System.out.println(pow(0.2,0));
        System.out.println(pow(-2,3));
        System.out.println(pow(-2,2));
    }
    // time O(logn) n>=0
    public static double power(double x, int n){
        if(n == 0) return 1;
        double v = power(x, n/2);
        if(n%2 == 0) {
            return v*v;
        } else {
            return x*v*v;
        }
    }
    public static double pow(double x, int n){
        if(n<0){
            return 1.0/power(x,-n);
        }else {
            return power(x,n);
        }
    }
}
