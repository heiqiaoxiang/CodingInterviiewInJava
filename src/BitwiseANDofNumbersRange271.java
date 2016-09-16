/**
 * Created by parallel on 9/16/16.
 */
public class BitwiseANDofNumbersRange271 {
    /**
     * problem:
     * Given a range [m, n] where 0 <= m <= n <=
     * 2147483647, return the bitwise AND of all numbers
     * in this range, inclusive. For example, given the
     * range [5, 7], you should return 4. Java Solution
     * @param args
     */
    public static void main(String[] args){
        System.out.println(rangeBitwiseAnd(5,7));
        System.out.println(rangeBitwiseAnd(4,8));
        System.out.println(rangeBitwiseAnd(26,30));
    }

    /**
     * solution :
     * The key to solve this problem is bitwise AND consecutive numbers. You can use the
     * following example to walk through the code.
     *   | 8 4 2 1
     * ---------------
     * 5 | 0 1 0 1
     * 6 | 0 1 1 0
     * 7 | 0 1 1 1
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m, int n){
        while(n>m){
            n = n & (n-1); // remove last bit-1 of n;
        }
        return m & n;
    }
}
