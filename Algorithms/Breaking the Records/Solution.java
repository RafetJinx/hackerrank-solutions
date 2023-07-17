// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /**
     * Calculates the counts of breaking records for maximum and minimum scores in a
     * list of scores.
     *
     * @param scores The list of scores for which breaking records counts are to be
     *               calculated.
     * @return A list containing the counts of breaking records for maximum and
     *         minimum scores.
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> counts = maxMinChangeCount(scores);

        return counts;
    }

    /**
     * Calculates the counts of breaking records for maximum and minimum scores in a
     * list of scores.
     *
     * @param scores The list of scores for which breaking records counts are to be
     *               calculated.
     * @return A list containing the counts of breaking records for maximum and
     *         minimum scores.
     */
    public static List<Integer> maxMinChangeCount(List<Integer> scores) {
        int max = 0;
        int maxChangedCount = 0;

        int min = 0;
        int minChangedCount = 0;

        for (int i = 0; i < scores.size(); i++) {
            if (i == 0) {
                max = scores.get(i);
                min = scores.get(i);
                continue;
            }

            if (scores.get(i) > max) {
                max = scores.get(i);
                maxChangedCount++;
            }

            if (scores.get(i) < min) {
                min = scores.get(i);
                minChangedCount++;
            }
        }

        List<Integer> counts = new ArrayList<>();

        counts.add(maxChangedCount);
        counts.add(minChangedCount);

        return counts;
    }

    public static void printCounts(int[] counts) {
        System.out.println(counts[0] + " " + counts[1]);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
