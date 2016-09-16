/**
 * Created by parallel on 9/16/16.
 */
public class SumOfTwoIntegers272 {

    /**
     * problem:
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator
     *  + and -.
     * Example: Given a = 1 and b = 2, return 3.
     * @param args
     */
    public static void main(String[] args){
        System.out.println(getSum(1,2));
        System.out.println(getSum(-10,2));
        System.out.println(getSum(10,0));
    }

    /**
     * solution:
     * Given two numbers a and b, a&b returns the number formed by ’1’ bits on a and b.
     * When it is left shifted by 1 bit, it is the carry.
     * For example, given a=101 and b=111 (in binary), the a&b=101. a&b «1 = 1010.
     * a b ˆ is the number formed by different bits of a and b. a&b=10.
     * @param a
     * @param b
     */
    public static int getSum(int a, int b){
        while(b!=0){
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
}
