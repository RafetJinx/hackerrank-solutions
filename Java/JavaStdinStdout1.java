import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        readTreeIntInScannerAndPrint(scanner);
    }
    
    /** 
    *   A function that reads three integers from the user using a Scanner object
    *   and prints them separately to the console.
    *
    *   @param scanner The Scanner object used to read input from the user.
    */
    public static void readTreeIntInScannerAndPrint(Scanner scanner){
        // scanner scan 3 integers and add nums array
        int[] nums = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        
        for(int num : nums){
            System.out.println(num);
        }
    }
}
