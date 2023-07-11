import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        scanSeriesAndPrint(scanner);
        
        scanner.close();
    }
    
    /**
    * Reads the number of series to process and calls the printSeries function.
    *
    * @param scanner The Scanner object used to read input from the user.
    */    
    public static void scanSeriesAndPrint(Scanner scanner){
        // t => line count
        int t = scanner.nextInt();
        
        for(int i = 0; i < t; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            
            printSeries(a,b,n);
        }
    }
    
    /**
    * Prints the series based on the given parameters
    *
    * @param a The initial term of the series.
    * @param b The common ratio of the series.
    * @param n The number of terms in the series.
    */    
    public static void printSeries(int a, int b, int n){
        int result = a;
        for(int i = 0; i < n; i++){
            result += Math.pow(2, i) * b;
            System.out.print(result + " ");
        }
        System.out.println();
    }
}