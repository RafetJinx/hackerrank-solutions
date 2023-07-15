// Used HackerRank Java 8 Template 

import java.io.*;

class Result {
    
    public static String timeConversion(String s) {
        
        
        return convertTime(s);
    }
    
    /**
    * Converts the time from 12-hour AM/PM format to 24-hour format.
    *
    * @param s The time in 12-hour AM/PM format (hh:mm:ssAM or hh:mm:ssPM).
    * @return The time in 24-hour format (hh:mm:ss).
    */
    public static String convertTime(String s){
        // "12:01:00AM";
        
        int hours = Integer.parseInt(s.substring(0, 2)); // "12"
        int minutes = Integer.parseInt(s.substring(3, 5)); // "01"
        int seconds = Integer.parseInt(s.substring(6, 8)); // "00"
        String meridiem = s.substring(8, 10);
        
        if(meridiem.equals("PM") && hours != 12){
            hours += 12;
        } else if(meridiem.equals("AM") && hours == 12){
            hours = 0;
        }
        
        String formattedDate = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        
        return formattedDate;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
