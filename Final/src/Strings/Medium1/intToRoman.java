package Strings.Medium1;

import java.util.ArrayList;

public class intToRoman {
    static class Obj {
        String s;
        int x;

        Obj(String s, int x) {
            this.s = s;
            this.x = x;
        }
    }

    public static String IntToRoman(int num) {
        ArrayList<Obj> arr = new ArrayList<>();
        arr.add(new Obj("I", 1));
        arr.add(new Obj("IV", 4));
        arr.add(new Obj("V", 5));
        arr.add(new Obj("IX", 9));
        arr.add(new Obj("X", 10)); // Added "X" (missing from original code)
        arr.add(new Obj("XL", 40));//To map roman values in string to their int value
        arr.add(new Obj("L", 50));
        arr.add(new Obj("XC", 90));
        arr.add(new Obj("C", 100));
        arr.add(new Obj("CD", 400));
        arr.add(new Obj("D", 500));
        arr.add(new Obj("CM", 900));
        arr.add(new Obj("M", 1000));

        StringBuilder ans = new StringBuilder(); // Use StringBuilder for better performance

        for (int i = arr.size() - 1; i >= 0; i--) {
            int count = num / arr.get(i).x;
            while (count > 0) {
                ans.append(arr.get(i).s); // Append to StringBuilder
                count--;
            }
            num %= arr.get(i).x; // Update num to the remainder
        }
        return ans.toString(); // Convert StringBuilder to String
    }
}


