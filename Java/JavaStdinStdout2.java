import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        readTreeLineInScannerAndPrint(scanner);
    }
    
    /**
    * A function that reads an integer, a double, and a string from the user using
    * a Scanner object and prints them in the specified order.
    * Order is (String, Double, Integer)
    * 
    * @param scanner The Scanner object used to read input from the user.
    */
    public static void readTreeLineInScannerAndPrint(Scanner scanner){
        // Exp = Expression
        int intExp = scanner.nextInt();
        double doubleExp = scanner.nextDouble();
        
        scanner.nextLine();
        String strExp = scanner.nextLine();
        
        System.out.println("String: " + strExp);
        System.out.println("Double: " + doubleExp);
        System.out.println("Int: " + intExp);
    }
}
