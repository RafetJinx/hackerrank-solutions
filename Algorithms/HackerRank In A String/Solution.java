// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.stream.*;

class Result {
    private static final char[] HACKERRANK_CHARACTERS = {'h','a','c','k','e','r','r','a','n','k'};

    /**
     * Determines if the given string contains the characters in "hackerrank" in order.
     *
     * @param s The input string.
     * @return "YES" if the string contains "hackerrank" in order, "NO" otherwise.
     */
    public static String hackerrankInString(String s) {
        char[] chars = s.toCharArray();
        
        boolean isContains = containsHackerRank(chars);
        
        String result = printIsContainsHackerRank(isContains);
        
        return result;
    }
    
    /**
     * Converts the boolean result of containing "hackerrank" into the corresponding 
     * "YES" or "NO" string.
     *
     * @param isContains Whether "hackerrank" is contained in order.
     * @return "YES" if isContains is true, "NO" otherwise.
     */
    public static String printIsContainsHackerRank(boolean isContains){
        if(isContains){
            return "YES";
        } else {
            return "NO";
        }
    }
    
    /**
     * Checks if the character array contains the characters in "hackerrank" in order.
     *
     * @param chars The character array to check.
     * @return True if the array contains "hackerrank" in order, false otherwise.
     */
    public static boolean containsHackerRank(char[] chars){
        int countedChars = 0;
        
        for(char ch : chars){
            if(countedChars == HACKERRANK_CHARACTERS.length){
                break;
            }
            
            if(ch == HACKERRANK_CHARACTERS[countedChars]){
                countedChars++;
            }
        }
        
        return countedChars == HACKERRANK_CHARACTERS.length;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
