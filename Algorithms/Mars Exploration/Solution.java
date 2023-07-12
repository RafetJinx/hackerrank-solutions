// Used HackerRank Java 8 Template 

import java.io.*;

class Result {
    private static char[] SOS_CHARACTERS = {'S', 'O', 'S'};

    /**
     * Counts the number of altered characters in the given string.
     *
     * @param s The input string.
     * @return The count of altered characters.
     */
    public static int marsExploration(String s) {
        
        int changedLetterCount = calculateChangedLetters(s);
        
        return changedLetterCount;
    }
    
    /**
     * Calculates the count of altered characters in a given string by comparing it with 
     * the SOS sequence.
     *
     * @param s The input string.
     * @return The count of altered characters.
     */
    public static int calculateChangedLetters(String s){
        int changedLetters = 0;
        
        for(int i = 0; i < s.length(); i += 3){
            String subSos = s.substring(i, i + 3);
            
            if(subSos.charAt(0) != SOS_CHARACTERS[0]){
                changedLetters++;        
            }
            
            if(subSos.charAt(1) != SOS_CHARACTERS[1]){
                changedLetters++;        
            }
            
            if(subSos.charAt(2) != SOS_CHARACTERS[2]){
                changedLetters++;        
            }
            
            
            // This for loop in comments because if we want to use for loop
            // our code time complexity it would go from O(n) to O(n^2)
            /*
            for(int j = 0; j < SOS_CHARACTERS.length; j++){
                if(subSos.charAt(j) != SOS_CHARACTERS[j]){
                    changedLetters++;        
                }
            }
            */
            
        }
        
        return changedLetters;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
