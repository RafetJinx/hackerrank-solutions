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

        multiplyAndPrint(N);

        bufferedReader.close();
    }
    
    /**
    * Print the multiplication table for a given integer from 1 to 10.
    * Each line of the table shows the multiplication of the given integer with the numbers from 1 to 10.
    * 
    * @param The integer for which the multiplication table is generated.
    */
    public static void multiplyAndPrint(int num){
        int result = 0;
        for(int i = 1; i <= 10; i++){
            result = num * i;
            System.out.println(num + " x " + i + " = " + result);
        }
    }
}
