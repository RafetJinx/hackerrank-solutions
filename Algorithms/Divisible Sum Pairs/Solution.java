// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /**
    * Calculates the count of divisible sum pairs in a list of integers.
    *
    * @param n      The size of the array.
    * @param k      The divisor.
    * @param ar     The list of integers.
    * @return       The count of divisible sum pairs.
    */
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int count = divisibleCount(n, k, ar);
        
        return count;
    }
    
    /**
    * Calculates the count of divisible sum pairs in a list of integers.
    *
    * @param numSize      The size of the array.
    * @param modeNumber   The divisor.
    * @param nums         The list of integers.
    * @return             The count of divisible sum pairs.
    */
    public static int divisibleCount(int numSize, int modeNumber, List<Integer> nums){
        int count = 0;
        
        for(int i = 0; i < numSize - 1; i++){
            for(int j = i + 1; j < numSize; j++){
                if((nums.get(i) + nums.get(j)) % modeNumber == 0){
                    count++;
                }
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

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
