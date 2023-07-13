// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;

class Result {

    /**
     * Determines if the given string is a pangram.
     * A pangram is a sentence that contains every letter of the alphabet at least once.
     *
     * @param s the input string to check for pangram
     * @return the string "pangram" if s is a pangram, otherwise "not pangram"
     */
    public static String pangrams(String s) {
        
        boolean pangram = isPangram(s);
        
        return returnPanagramStatus(pangram);
    }
    
    /**
     * Checks if the given string is a pangram.
     *
     * @param str the input string to check for pangram
     * @return true if str is a pangram, otherwise false
     */
    public static boolean isPangram(String str){
        Set<Character> alphabet = new HashSet<>();
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(Character.isLetter(ch)){
                alphabet.add(Character.toLowerCase(ch));
            }
        }
        
        return alphabet.size() == 26;
    }
    
    /**
     * Returns the status of a pangram as a string.
     *
     * @param exp the boolean value indicating if a string is a pangram or not
     * @return "pangram" if exp is true, otherwise "not pangram"
     */
    public static String returnPanagramStatus(boolean exp){
        if(exp){
            return "pangram";
        } else {
            return "not pangram";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
