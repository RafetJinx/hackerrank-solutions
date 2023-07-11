import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        boolean weird = isWeird(N);
        printWeirdness(weird);

        bufferedReader.close();
    }
    
    public static boolean isWeird(int num){
        // Check num is odd
        if(num % 2 == 1){
            return true;
        }
        
        // Check num is range of 6 to 20
        if(num >= 6 && num <= 20){
            return true;
        }
        
        return false;
    }
    
    public static void printWeirdness(boolean isWeird){
        if(isWeird){
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
    }
}
