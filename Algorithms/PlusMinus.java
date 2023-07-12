// Used HackerRank Java 8 Template 

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Calculates and prints the fraction of positive, negative, and zero numbers in a given list.
     *
     * @param arr The list of integers
     */
    public static void plusMinus(List<Integer> arr) {
        int positiveNumCount = 0;
        int negativeNumCount = 0;
        int zeroNumCount = 0;
        
        for(Integer num : arr){
            if(num == 0){
                zeroNumCount++;
            }
            
            if(num > 0){
                positiveNumCount++;
            }
            
            if(num < 0){
                negativeNumCount++;
            }
        }
        
        DecimalFormat decimalFormat = new DecimalFormat("#0.000000");
        
        System.out.println(decimalFormat.format((double) positiveNumCount / arr.size()));
        System.out.println(decimalFormat.format((double) negativeNumCount / arr.size()));
        System.out.println(decimalFormat.format((double) zeroNumCount / arr.size()));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
