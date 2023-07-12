// Used HackerRank Java 8 Template 

import java.io.*;

class Result {

    /*
     * Prints the staircase pattern with a given size
     *
     * @param n The size of the staircase
     */
    public static void staircase(int n) {
        for(int numSymbols = 1; numSymbols <= n; numSymbols++){
            int numSpaces = n - numSymbols;
            
            for(int i = 0; i < numSpaces; i++){
                System.out.print(" ");
            }
            
            for(int i = 0; i < numSymbols; i++){
                System.out.print("#");
            }
            System.out.println();
        }
        
        /*
        IntStream.rangeClosed(1, n)
            .forEach(i -> {
                String spaces = IntStream.range(0, n - i)
                                            .mapToObj(j -> " ")
                                            .collect(Collectors.joining());
                                                
                String hashes = IntStream.range(0, i)
                                            .mapToObj(j -> "#")
                                            .collect(Collectors.joining());
                                            
                System.out.println(spaces + hashes);
            });
        */
    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
