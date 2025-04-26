package CustomSort;
import java.util.*;
class cmp implements Comparator<Integer>{
    public int compare(Integer o1 , Integer o2){
        if(o1>o2){
            return -1;
        }
        else{
            return 1;
        }
    }
}
public class Decrreasing {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(34);
        arr.add(21);
        arr.add(67);     // Custom sorting applied through implementing comparator<Integer> interface and overriding compare(function)
        arr.add(1);
        arr.add(90);
        arr.add(121);
        Collections.sort(arr,new cmp());
        System.out.println(arr);
    }
}
