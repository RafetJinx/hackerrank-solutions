// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /**
    * Finds the most frequently sighted bird type among the given list of sightings.
    *
    * @param arr The list of bird sightings.
    * @return The most frequently sighted bird type.
    */
    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birdsMap = countFrequentlySightedTypes(arr);
        
        int maxValue = getMinimumKeyOfMaxValue(birdsMap);
        
        return maxValue;
    }

    
    /**
     * Counts the frequency of each sighted type in a given list.
     *
     * @param sightings The list of sighted types.
     * @return A map with sighted types as keys and their corresponding frequencies as values.
     */
    public static Map<Integer, Integer> countFrequentlySightedTypes(List<Integer> sightings) {
        Map<Integer, Integer> sightedTypesCount = new HashMap<>();
        
        for (Integer sighting : sightings) {
            sightedTypesCount.put(sighting, sightedTypesCount.getOrDefault(sighting, 0) + 1);
        }
        
        return sightedTypesCount;
    }
    
    /**
     * Retrieves the minimum key associated with the maximum value in a given map.
     *
     * @param countMap The map containing the sighted types as keys and their frequencies as values.
     * @return The minimum key associated with the maximum value.
     */
    public static int getMinimumKeyOfMaxValue(Map<Integer, Integer> countMap) {
        int maxCount = Collections.max(countMap.values());
        int minKey = Integer.MAX_VALUE;
        
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount && entry.getKey() < minKey) {
                minKey = entry.getKey();
            }
        }
        
        return minKey;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
