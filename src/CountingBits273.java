/**
 * Created by parallel on 9/16/16.
 */
public class CountingBits273 {
    /**
     * problem:
     * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤
     * num calculate the number of 1’s in their binary representation and return them as an
     * array.
     * Example:
     * For num = 5 you should return [0,1,1,2,1,2].
     * @param args
     */
    public static void main(String[] args){
        printIntArray(countBits(19));
    }

    /**
     * solution:
     * For number 2(10), 4(100), 8(1000), 16(10000), ..., the number of 1’s is 1. Any other
     * ˆ + x. For example, 9=8+1, 10=8+2. The number of
     * number can be converted to be 2 m
     * 1’s for any other number is 1 + # of 1’s in x.
     *  N=pow+p           #of 1's
     *  1                   1
     *  2                   1
     *  3=2+1               2
     *  4                   1
     *  5=4+1               2
     *  6=4+2               2
     *  7=4+3               3=2+1
     *  8                   1
     *  9=8+1               2
     *  10=8+2              2
     *  ...                 ...
     * @param num
     * @return
     */
    public static int[] countBits(int num){
        int[] result = new int[num+1];
        int p = 1;
        int pow = 1;
        for(int i=1;i<=num;i++){
            if(i==pow){
                result[i] = 1;
                pow <<= 1;
                p = 1;
            } else{
                result[i] = result[p] + 1;
                p++;
            }
        }
        return result;
    }
//    print
    public static void printIntArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(i+"\t"+arr[i]);
        }
    }
}
