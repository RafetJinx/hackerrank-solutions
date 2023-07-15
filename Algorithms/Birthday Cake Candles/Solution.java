// Used HackerRank Java 8 Template

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int birthdayCakeCandles(List<Integer> candles) {
        return findMaxCount(candles);
    }
    
    /**
     * Finds the count of the maximum candles in the given list.
     *
     * @param candles A list of candle heights.
     * @return The count of the tallest candles.
     */
    public static int findMaxCount(List<Integer> candles){
        int max = 0;
        int count = 0;
        
        for(Integer candle : candles){
            if(candle > max){
                max = candle;
                count = 1;
            } else if(candle == max){
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

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
