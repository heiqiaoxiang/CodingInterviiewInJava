package old;

/**
 * Created by parallel on 9/16/16.
 */
public class MaximumProductOfWordLengths274 {
    /**
     * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
     where the two words do not share common letters. You may assume that each word
     will contain only lower case letters. If no such two words exist, return 0.
     * @param args
     */
    public static void main(String[] args){
        System.out.println(maxProduct("Given a string array words".trim().split("\\s+")));
        System.out.println(maxProduct("find the maximum value of length".trim().split("\\s+")));
        System.out.println(maxProduct("where the two words do not share common letters. You may assume that each word".trim().split("\\s+")));
    }
    public static int maxProduct(String[] words){
        if(words == null || words.length == 0)
            return 0;
        int[] arr = new int[words.length];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char c = words[i].charAt(j);
                arr[i] |= (1<<(c-'a')); // arr[i] at most has 26 bits.
            }
        }
        int result = 0;
        int index1=0, index2=0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
//                if two words share common letter, arr[i]&arr[j]!=0
                if((arr[i] & arr[j]) == 0) { // & < ==
                    int tmp = words[i].length() * words[j].length();
                    if(tmp > result){
                        index1 = i;
                        index2 = j;
                        result = tmp;
                    }
//                    result = Math.max(result, tmp);
                }
            }
        }
        System.out.println(words[index1]+"\t"+words[index2]);
        return result;
    }
}
