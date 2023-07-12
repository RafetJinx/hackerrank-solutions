// Used HackerRank Java 8 Template 

import java.util.*;

public class SolveMeFirst {

    /**
    *   Calculates the sum of two integers.
    *
    *   This method takes two integer values, 'a' and 'b', and returns their sum.
    *
    *   @param a The first integer value.
    *   @param b The second integer value.
    *   @return The sum of 'a' and 'b'.
    */
    static int solveMeFirst(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a;
        a = scanner.nextInt();
        int b;
        b = scanner.nextInt();
        
        int sum;
        sum = solveMeFirst(a, b);
        
        System.out.println(sum);
        
        scanner.close();
    }
}
