package old;

/**
 * Created by parallel on 9/16/16.
 */
public class ReverseBits269 {
    /**
     * problem:
     * Reverse bits of a given 32 bits unsigned integer.
     * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
     * return 964176192 (represented in binary as 00111001011110000010100101000000).
     * Follow up: If this function is called many times, how would you optimize it?
     * Related problem: Reverse Integer
     * @param args
     */
    public static void main(String[] args){
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits(5));
    }

    /**
     * solution:
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n){
       for(int i=0;i<16;i++){
           n = swapBits(n, i, 32 - 1 - i);
       }
       return n;
    }
    public static int swapBits(int n, int i, int j){
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;
        if((a ^ b) != 0){
            return n ^= (1 << i) | (1 << j); // a=0/1, a^1=~a.
        }
        return n;
    }

}
