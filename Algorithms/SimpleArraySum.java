// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Calculates the sum of integers in a list
     *
     * @param ar The list of integers
     * @return The sum of all the integers in the list.
     */

    public static int simpleArraySum(List<Integer> ar) {
        int sum = 0;
        
        Iterator<Integer> iterator = ar.iterator();
        
        // Iterating over the elements of the list using a while loop
        while(iterator.hasNext()){
            int num = iterator.next();
            
            sum += num;
        }
        
        return sum;
    }

}

public class SimpleArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.simpleArraySum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
