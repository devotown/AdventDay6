import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.ArrayList;

public class Driver {

  ArrayList<Race> races;
  public static void main(String[] args) {
    Driver driver = new Driver();
    driver.races = new ArrayList<>();
    String fileContent = "";
    try {
      String filePath = "/Users/devontownsend/Documents/AdventOfCode Day 6/src/input.txt"; // Replace with the actual file path
      fileContent = readFileToString(filePath);

      // Print or use the file content as needed
      System.out.println("File Content:\n" + fileContent);
    } catch (IOException e) {
      e.printStackTrace();
      // Handle the IOException, e.g., file not found or unable to read
    }
    // Parse Data into the race
    String[] parts = fileContent.split("\\n");

    // Optional: Trim leading and trailing whitespaces from each part
    for (int i = 0; i < parts.length; i++) {
      parts[i] = parts[i].trim();
    }

    System.out.println(parts[0] + "\n");
    System.out.println(parts[1]);

    String distance = parts[1];
    String time = parts[0];

    String distanceData = splitStringByColon(distance);
    String timeData = splitStringByColon(time);

    long[] distanceDataList = splitStringByWhitespace(distanceData);
    long[] timeDataList = splitStringByWhitespace(timeData);
    long length = distanceDataList.length;

    for (long datum : distanceDataList) {
      System.out.println(datum);
    }
    for (long datum : timeDataList) {
      System.out.println(datum);
    }

    for (int i = 0; i < length; ++i) {
      // Create a new Race object
      // Store it to the List of races
      driver.races.add(new Race(timeDataList[i], distanceDataList[i]));
    }
    long power = 1;
    for (Race race : driver.races){
      power = power * race.getWaysToWin();
    }

    System.out.println(power);

    // Parse Time and Distance variables
    // Method that parses at the colon and then creates an array of variables split by whitespace

    // Create game with n and r

    // Get n and r
  }

  public static String splitStringByColon(String input) {
    // Split the input string by colon
    String[] parts = input.split(":");

    // Optional: Trim leading and trailing whitespaces from each part
    for (int i = 0; i < parts.length; i++) {
      parts[i] = parts[i].trim();
    }

    return parts[1];
  }

  public static long[] splitStringByWhitespace(String input) {
    // Split the input string by any amount of whitespace
    String[] parts = input.split("\\s+");
    long[] data = new long[parts.length];

    // Optional: Trim leading and trailing whitespaces from each part
    for (int i = 0; i < parts.length; i++) {
      parts[i] = parts[i].trim();
      data[i] = Long.parseLong(parts[i]);
    }

    return data;
  }


  public static String readFileToString(String filePath) throws IOException {
    // Read all lines from the file and join them into a single String
    return String.join(System.lineSeparator(), Files.readAllLines(Path.of(filePath)));
  }

}
