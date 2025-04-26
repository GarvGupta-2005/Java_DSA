package Strings.Hard;
import java.util.*;

public class StringHashing {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("aa");        
        arr.add("ab");
        arr.add("aa");
        arr.add("b");
        arr.add("c");
        arr.add("dd");
        arr.add("b");

        // //This is the brute way of first sort the arrays and then count
        // Collections.sort(arr);
        // int dist = 1; // first string is always counted
        // for (int i = 1; i < arr.size(); i++) {
        //     if (!arr.get(i).equals(arr.get(i - 1))) {
        //         dist++;
        //     }
        // }

        // System.out.println(dist); // Output: 5



    }
}
