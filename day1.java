package Coding_Chalenge;
import java.util.Scanner;

public class day1 {
    public static String getSmallestAndLargest(String s, int k) { //Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest and largest substrings of length .
        String smallest = s.substring(0,k);
        String largest = "";
        for(int i=0;i<s.length()-k+1;i++){
            if (s.substring(i, i+k).compareTo(largest) > 0) {
                largest = s.substring(i, i+k);
            }
            if (s.substring(i, i+k).compareTo(smallest) < 0) {
                smallest = s.substring(i, i+k);
            }

        }
        
        
        return smallest +"\n"+largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
