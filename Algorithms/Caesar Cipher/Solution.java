// Used HackerRank Java 8 Template 

import java.io.*;
class Result {
    public static int APLHABET_LETTER_COUNT = 26;
    
    
    /**
    * Encrypts a given string using the Caesar Cipher algorithm with a specified rotation factor.
    *
    * @param s The string to be encrypted.
    * @param k The rotation factor for the cipher.
    * @return The encrypted string.
    */
    public static String caesarCipher(String s, int k) {
        StringBuilder encryptedStringBuilder = new StringBuilder();
        
        // Iterate over each character in the input string
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isLetter(ch)){
                char initialSituation = Character.isLowerCase(ch) ? 'a' : 'A';
                
                // calculate the number of positions to shift the character
                int appendCount = (ch - initialSituation + k) % APLHABET_LETTER_COUNT;
                
                // Shift the character by the calculated offset
                char encryptedChar = (char) (initialSituation + appendCount);
                
                encryptedStringBuilder.append(encryptedChar);
            } else {
                // Non-letter cahacter, append as is.
                encryptedStringBuilder.append(ch);
            }
        }
        
        String encryptedString = encryptedStringBuilder.toString();
        
        return encryptedString;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
