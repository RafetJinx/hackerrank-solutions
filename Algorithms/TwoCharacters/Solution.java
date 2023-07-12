import java.io.*;
import java.util.*;

class Result {
    /**
     * Calculates the length of the longest alternating substring in the given string.
     *
     * @param s The input string.
     * @return The length of the longest alternating substring.
     */
    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for(char c : s.toCharArray()){
            uniqueChars.add(c);
        }
        
        int maxLength = 0;
        ArrayList<Character> charList = new ArrayList<>(uniqueChars);
        
        // Iterate over each pair of characters and find the longest alternating substring
        for(int i = 0; i < charList.size() - 1; i++){
            for(int j = i + 1; j < charList.size(); j++){
                char char1 = charList.get(i);
                char char2 = charList.get(j);
                
                StringBuilder stringBuilder = new StringBuilder();
                
                for(char c : s.toCharArray()){
                    if(c == char1 || c == char2){
                        stringBuilder.append(c);
                    }
                }
                
                if(isAlternate(stringBuilder.toString())){
                    maxLength = Math.max(maxLength, stringBuilder.length());
                }
            }
        }
    
        return maxLength;
    }
    
    /**
     * Checks if a string is alternating, i.e., no two adjacent characters are the same.
     *
     * @param s The input string.
     * @return true if the string is alternating, false otherwise.
     */
    public static boolean isAlternate(String s){
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
