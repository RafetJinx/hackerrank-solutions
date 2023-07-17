// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /**
    * Calculates the number of possible ways to divide a list of numbers to achieve a desired sum.
    *
    * @param s       The list of integers representing the available numbers.
    * @param d       The desired sum.
    * @param m       The number of integers to be considered in each division.
    * @return        The count of possible divisions that sum up to the desired value.
    */
    
    public static int birthday(List<Integer> s, int d, int m) {
        return findDivideCount(s, d, m);
    }
    
    
    /**
    * Finds the count of possible divisions in a list of numbers that sum up to a given value.
    *
    * @param nums        The list of integers to be divided.
    * @param searchedNum The desired sum to be achieved.
    * @param numRange    The number of integers to be considered in each division.
    * @return            The count of possible divisions that sum up to the desired value.
    */
    public static int findDivideCount(List<Integer> nums, int searchedNum, int numRange){
        if(numRange > nums.size()){
            return 0;
        }
        
        int count = 0;
        
        for(int i = 0; i <= nums.size() - numRange; i++){
            int sum = 0;
            
            for(int j = 0; j < numRange; j++){
                sum += nums.get(i + j);
            }
                
            if(sum == searchedNum){
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

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
