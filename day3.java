package Coding_Chalenge;

import java.util.*;
public class day3 {


public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine().trim();
if(s.length()!=0){

        String [] tokens = s.split("[^a-zA-Z]+");

System.out.println(tokens.length);
//  we use for eah loop which is easy to access 
for(String str: tokens){
    System.out.println(str);
}
}
else{
    System.out.println("0");
}

scan.close();
} 
}
