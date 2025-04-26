
import java.util.*;

public class HashMap1 {
    public static void main(String[] args) {
        HashMap<String,Integer> m = new HashMap<>();
        m.put("Rohan", 45);
        m.put("Sohan", 65);
        System.out.println(m);
        m.put("Sohan", 67);//Put method not only put values but also updates the key value if the key exisits
        System.out.println(m);
        m.remove("Sohan");
        System.out.println(m.containsKey("Garv")); // to find whether a map contains this particular key or not
        HashSet<String> hs = new HashSet<>();
        System.out.println(hs);
    }
}

