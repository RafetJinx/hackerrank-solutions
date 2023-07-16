// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /**
     * Counts the number of apples and oranges that fall within the given house range.
     *
     * @param s       the starting point of the house range
     * @param t       the ending point of the house range
     * @param a       the position of the apple tree
     * @param b       the position of the orange tree
     * @param apples  the list of apple positions relative to the apple tree
     * @param oranges the list of orange positions relative to the orange tree
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int appleCount = countFruitsInRage(s, t, a, apples);
        int orangecount = countFruitsInRage(s, t, b, oranges);
        
        System.out.println(appleCount);
        System.out.println(orangecount);
    }
    
    /**
     * Counts the number of fruits that fall within the given house range for a specific tree.
     *
     * @param houseStart    the starting point of the house range
     * @param houseEnd      the ending point of the house range
     * @param treePosition  the position of the tree
     * @param fruits        the list of fruit positions relative to the tree
     * @return the count of fruits that fall within the house range
     */
    public static int countFruitsInRage(int houseStart, int houseEnd, int treePosition, List<Integer> fruits){
        int count = 0;
        
        for(int fruit : fruits){
            int fruitPosition = treePosition + fruit;
            
            if(houseStart <= fruitPosition && fruitPosition <= houseEnd){
                count++;
            }
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
