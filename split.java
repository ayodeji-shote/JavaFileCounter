import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Map;
public class split {
    public static void main(String[] args) {
        
        split st = new split();
        st.menu(args[0]);
    }

private void menu(String args)
{
    System.out.println("Do you want Case Sensitive or not Case Sensitive? ");
    System.out.println(" Press 1 for case not case sensitive. ");
    System.out.println(" Press 2 for Case Sensitive. ");
    Scanner scan = new Scanner(System.in);
    int op = 0;
    try {
         op = scan.nextInt();
    } catch (InputMismatchException e) {
       System.out.println("Your answer can only be one or two");
    }

if (op ==1 || op == 2) {
    switch (op) { 
        case 1:
        fileReader1(args);
        break;
        case 2:
        fileReader2(args);
        break;
    }
    scan.close();
}
else {
    System.out.println("please select a valid option");
    menu(args);
    System.exit(0);
    
}




}
private void fileReader1(String args) {
    args =args.replaceAll(".txt","");
    try {
    String filerd = null;
    Scanner sc = new Scanner(args); 
    filerd = sc.nextLine();
    File myfile = new File(filerd);
    Scanner filereader = new Scanner(myfile);
    String dt = "";
    while (filereader.hasNextLine()) {
         dt = dt +filereader.nextLine();
        dt =dt.replaceAll("\\s+","");
        dt = dt.toLowerCase();    
    }
    System.out.println("the Total number of characters is: " + dt.length());
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i = 0; i < dt.length(); i++){
        // Takes one character from the string
        char ky = dt.charAt(i);
        // checks if the character is in the map and if it is then increase the value by one
        if(map.containsKey(ky)){
            map.put(ky, map.get(ky) + 1);
        }
        else{
          //if the value isnt in the map then put a value of one
          map.put(ky, 1);
        }
      }
      // Displaying the map values
    LinkedHashMap<Character, Integer> sortedmap = new LinkedHashMap<>();
    map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .forEachOrdered(x -> sortedmap.put(x.getKey(), x.getValue()));
    map = sortedmap;
    //this is a counter to check that we are only printing the 10 largest values 
    int cn = 0;
    Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext() && cn <10) {
    Map.Entry<Character, Integer> entry = iterator.next();
    System.out.println(entry.getKey() + ":" + entry.getValue());
    cn++;
}
        filereader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("Error opening file " + e.getMessage());
    }
    
    }



private void fileReader2(String args) {
args =args.replaceAll(".txt","");
try {
String filerd = null;
Scanner sc = new Scanner(args); 
filerd = sc.nextLine();
File myfile = new File(filerd);
Scanner filereader = new Scanner(myfile);
String dt = "";
while (filereader.hasNextLine()) {
     dt = dt +filereader.nextLine();
    dt =dt.replaceAll("\\s+","");    
}
System.out.println("the Total number of characters is: " + dt.length());
Map<Character, Integer> map = new HashMap<Character, Integer>();
for(int i = 0; i < dt.length(); i++){
    // Takes one character from the string
    char ky = dt.charAt(i);
    // checks if the character is in the map and if it is then increase the value by one
    if(map.containsKey(ky)){
        map.put(ky, map.get(ky) + 1);
    }
    else{
      //if the value isnt in the map then put a value of one
      map.put(ky, 1);
    }
  }
// creating a Linked HashMap to hold the values of the map sorted in descending order then putting it in the previous map.
LinkedHashMap<Character, Integer> sortedmap = new LinkedHashMap<>();
map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .forEachOrdered(x -> sortedmap.put(x.getKey(), x.getValue()));
map = sortedmap;
//this is a counter to check that we are only printing the 10 largest values 
int cn = 0;
Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
while (iterator.hasNext() && cn <10) {
    Map.Entry<Character, Integer> entry = iterator.next();
    System.out.println(entry.getKey() + ":" + entry.getValue());
    cn++;
}
    filereader.close();
}
catch (FileNotFoundException e) {
    System.out.println("Error opening file " + e.getMessage());
}

}

}
