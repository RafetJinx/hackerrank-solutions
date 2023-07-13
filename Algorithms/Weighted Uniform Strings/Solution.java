// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /**
     * Returns a list of strings indicating whether each query weight exists in the 
     * weighted uniform string.
     *
     * @param s       the input string
     * @param queries the list of query weights
     * @return a list of strings ("Yes" or "No") representing the existence of query weights
     */
    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        
        Set<Integer> weights = findWeights(s);
        
        List<String> results = printQueriesContainsDetail(weights, queries);
        
        return results;
    }
    
    /**
     * Finds the weights of the substrings in the given string.
     *
     * @param s the input string
     * @return a set of weights for the substrings
     */
    public static Set<Integer> findWeights(String s){
        if(s.isEmpty()){
            return new HashSet<>();
        }
        
        Set<Integer> weights = new HashSet<>();

        int weight = s.charAt(0) - 'a' + 1;
        
        
        weights.add(weight);
        
        for(int i = 1; i < s.length(); i++){
            char currChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);
            
            if(currChar == prevChar){
                weight += currChar - 'a' + 1;
            } else {
                weight = currChar - 'a' + 1;
            }
            
            weights.add(weight);
        }
        
        return weights;
    }
    
    /**
     * Checks if the query weights exist in the list of weights.
     *
     * @param weights the set of weights
     * @param queries the list of query weights
     * @return a list of strings indicating the existence of each query weight
     */
    public static List<String> printQueriesContainsDetail(Set<Integer> weights, List<Integer> queries){
        List<String> results = new ArrayList<>();
        
        for(int i = 0; i < queries.size(); i++){
            if(weights.contains(queries.get(i))){
                results.add("Yes");
            } else {
                results.add("No");
            }
        }
        
        return results;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
