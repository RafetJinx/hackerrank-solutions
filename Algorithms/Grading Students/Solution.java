// Used HackerRank Java 8 Template 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    
    /**
     * Rounds the grades according to the specified rules.
     *
     * @param grades the list of grades to be rounded
     * @return the list of rounded grades
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> newGrades = new ArrayList<>();
        
        for(Integer grade : grades){
            
            if(grade < 38){
                newGrades.add(grade);
                continue;
            }
            
            int roundedGrade = roundGrade(grade);
            
            newGrades.add(roundedGrade);
        }
        
        return newGrades;
    }
    
    /**
     * Rounds the grade to the nearest multiple of 5 if the difference
     * between the grade and the next multiple of 5 is less than 3.
     *
     * @param grade the grade to be rounded
     * @return the rounded grade
     */
    public static int roundGrade(int grade){
        int nextMultipleOfFive = ((grade / 5) + 1) * 5;
        
        if(nextMultipleOfFive - grade < 3){
            return nextMultipleOfFive;
        }
        
        return grade;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
