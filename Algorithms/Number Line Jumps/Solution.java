// Used HackerRank Java 8 Template 

import java.io.*;

class Result {
    
    /**
     * Determines whether two kangaroos can meet at the same location.
     *
     * @param x1 the starting position of the first kangaroo
     * @param v1 the jumping distance of the first kangaroo
     * @param x2 the starting position of the second kangaroo
     * @param v2 the jumping distance of the second kangaroo
     * @return "YES" if the kangaroos can meet at the same location, "NO" otherwise
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 < v2) {
            return "NO";
        }

        boolean sameLocation = canCatch(x1, v1, x2, v2);

        return printSameLocation(sameLocation);
    }

    /**
     * Determines if two kangaroos can catch each other by checking 
     * their positions at each time step.
     *
     * @param x1 the starting position of the first kangaroo
     * @param v1 the jumping distance of the first kangaroo
     * @param x2 the starting position of the second kangaroo
     * @param v2 the jumping distance of the second kangaroo
     * @return true if the kangaroos can catch each other, false otherwise
     */
    public static boolean canCatch(int x1, int v1, int x2, int v2) {
        int xPosition;
        int yPosition;
        for (int i = 1; i <= 10000; i++) {
            xPosition = x1 + i * v1;
            yPosition = x2 + i * v2;

            if (xPosition == yPosition) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the string representation of whether the kangaroos are at the 
     * same location or not.
     *
     * @param sameLocation true if the kangaroos are at the same location, 
     * false otherwise
     * @return "YES" if the kangaroos are at the same location, "NO" otherwise
     */
    public static String printSameLocation(boolean sameLocation) {
        if (sameLocation) {
            return "YES";
        } else {
            return "NO";
        }
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
