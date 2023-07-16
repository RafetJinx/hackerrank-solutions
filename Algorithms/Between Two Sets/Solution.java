// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    
    /**
     * Calculates the total count of integers that are factors of all the elements in list 'a'
     * and are also multiples of all the elements in list 'b'.
     *
     * @param a the first list of integers
     * @param b the second list of integers
     * @return the total count of integers satisfying the conditions
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;

        int lcm = a.get(0);
        
        for(Integer element : a){
            lcm = getLCM(lcm, element);
        }
        
        
        int gcd = b.get(0);
        
        for(Integer element : b){
            gcd = getGCD(gcd, element);
        }
        
        result = countMultiplesLcmInGcd(lcm, gcd);
        
        return result;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     *
     * @param n1 the first integer
     * @param n2 the second integer
     * @return the GCD of the two integers
     */
    private static int getGCD(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        
        return getGCD(n2, n1 % n2);
    }
    
    /**
     * Calculates the least common multiple (LCM) of two integers.
     *
     * @param n1 the first integer
     * @param n2 the second integer
     * @return the LCM of the two integers
     */
    private static int getLCM(int n1, int n2){
        if(n1 == 0 || n2 == 0){
            return 0;
        }
        
        int gcd = getGCD(n1, n2);
        
        return Math.abs(n1 * n2) / gcd;
    }
    
    /**
     * Counts the number of multiples of 'lcm' that are factors of 'gcd'.
     *
     * @param lcm the least common multiple
     * @param gcd the greatest common divisor
     * @return the count of multiples of 'lcm' in 'gcd'
     */
    public static int countMultiplesLcmInGcd(int lcm, int gcd){
        int count = 0;
        int multiple = 0;
        
        while(multiple <= gcd){
            multiple += lcm;
            
            
            if(gcd % multiple == 0){
                count++;
            }
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
