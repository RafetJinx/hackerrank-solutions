import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        printFormattedResult(scanner);
    }
    
    /**
    *   Reads three lines of input, each containing a string and an integer
    *   and prints them with a spesific format.
    *
    *   @param scanner The Scanner object used to read input from the user.
    */
    public static void readThreeLineAndPrintWithFormat(Scanner scanner){
        // Expected input line count 3 ->
        for(int i = 0; i < 3; i++){
            String strExp = scanner.next();
            int intExp = scanner.nextInt();
            
            // %-15s -> for strExp
            // %03d -> for intExp
            // %n -> for new line
            System.out.printf("%-15s%03d%n", strExp, intExp);
        }
    }
    
    /**
    *   Prints the formatted result with header and footer lines.
    *
    * @param scanner The Scanner object used to read input from the user.
    */
    public static void printFormattedResult(Scanner scanner){
        System.out.println("================================");
        
        readThreeLineAndPrintWithFormat(scanner);
        
        System.out.println("================================");
    }
}
