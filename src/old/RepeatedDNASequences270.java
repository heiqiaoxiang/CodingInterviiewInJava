package old;

import java.util.*;

/**
 * Created by parallel on 9/16/16.
 */
public class RepeatedDNASequences270 {
    /**
     * Problem
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for
     * example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
     * repeated sequences within the DNA.
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more
     * than once in a DNA molecule.
     * For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", re-
     * turn: ["AAAAACCCCC", "CCCCCAAAAA"].
     * @param args
     */
    public static void main(String[] args){
        System.out.println(findRepeatedDNASequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    /**
     * solution:
     * The key to solve this problem is that each of the 4 nucleotides can be stored in 2 bits.
     * So the 10-letter-long sequence can be converted to 20-bits-long integer. The following
     * is a Java solution. You may use an example to manually execute the program and see
     * how it works.
     * @param s
     * @return
     */
    public static List<String> findRepeatedDNASequences(String s){
        List<String> result = new ArrayList<String>();
        int len = s.length();
        if(len < 10)
            return result;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> appeared = new HashSet<Integer>();
        Set<Integer> repeated = new HashSet<Integer>();

        int hash = 0;
        for(int i=0;i<len;i++){
            if(i<9){
//                each character(ACGT) fit 2 bits, so left shift 2.
                hash = (hash << 2) + map.get(s.charAt(i));
            } else {
                hash = (hash << 2) + map.get(s.charAt(i));
//                make length of hash to be 20 represent 10 chars.
                hash = hash & (1 << 20) - 1; // & < +/-
                if(appeared.contains(hash) && !repeated.contains(hash)){
                    result.add(s.substring(i-9, i+1)); // s[i-9,i+1)=s[i-9,i]
                    repeated.add(hash);
                } else {
                    appeared.add(hash);
                }
            }
        }
        return result;
    }

}
