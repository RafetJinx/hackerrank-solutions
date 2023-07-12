// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Calculates the minimum and maximum sums of a fiven list of integers.
     *
     * @param arr The list of integers
     */
    public static void miniMaxSum(List<Integer> arr) {
        arr.sort(null);
        
        long minSum = 0;
        long maxSum = 0;
        
        for(int i = 0; i < arr.size(); i++){
            if(i < arr.size() - 1){
                minSum += arr.get(i);
            }
            
            if(i > 0){
                maxSum += arr.get(i);
            }
        }
        
        System.out.println(minSum + " " + maxSum);
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
