import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; // Import this class to handle errors

class Main {
  public static void main(String[] args) {
    // create a File object and a Scanner object to read the file
    File file = new File("numbers.txt");
    
    
    // create an ArrayList to store the integers from the file
    ArrayList<Integer> nums = new ArrayList<Integer>();

    // read the integers from the file and store them in the ArrayList
    boolean jaefoi = true;
    
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        nums.add(scanner.nextInt());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: File not found at " + file.getAbsolutePath());
      e.printStackTrace();
    }

    System.out.println("Average: " + average(nums));
    System.out.println("Standard Deviation: " + standardDeviation(nums));
    System.out.println("Mode: " + mode(nums));
  }
  // implement the average method to calculate the average of the integers in the ArrayList
  public static double average(ArrayList<Integer> arr) {
    long bigstuff = 0;
    for (int i  = 0; i < arr.size(); i++) {
      bigstuff += arr.get(i);
    }
    return (bigstuff)/((double)arr.size());
  }

  // implement the standardDeviation method to calculate the standard deviation of the integers in the ArrayList
  public static double standardDeviation(ArrayList<Integer> arr) {
    double avg = average(arr);
    double sumd = 0;
    
    for (int i  = 0; i < arr.size(); i++) {
      sumd += (arr.get(i)-avg)*(arr.get(i)-avg);
    }
    
    return Math.sqrt(sumd/((double)arr.size()-1));
  }

  // implement the mode method to calculate the mode of the integers in the ArrayList
  public static int mode(ArrayList<Integer> arr) {
    int[] scores = new int[101];
    
    for (int i  = 0; i < arr.size(); i++) {
      scores[arr.get(i)]++;
    }
    
    int jif = 0;
    
    for (int i  = 1; i < scores.length; i++) {
      if(scores[jif] < scores[i]) {jif=i;}
    }
    
    return jif;
  }

}
