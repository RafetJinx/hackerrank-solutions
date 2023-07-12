// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
    *   Compares two list of integers and calculates the scores for each list.
    *
    *   @param a The first list of integers
    *   @param b The second list of integers
    *   @return A list containing the scores for list 'a' and list 'b' respectively.
    */
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> score = new ArrayList<>();
        
        // If the sizes of the input lists are not equal, return an empty score list
        if(a.size() != b.size()){
            return score;
        }
        
        int scoreA = 0;
        int scoreB = 0;
        
        // Iterating over the elements of the lists and comparing them
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) > b.get(i)){
                scoreA++;
            }
            
            if(a.get(i) < b.get(i)){
                scoreB++;
            }
        }
        
        score.add(scoreA);
        score.add(scoreB);
        
        return score;
    }

}

public class CompareTheTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
