package CustomSort;
import java.util.*;
class cmp implements Comparator<Integer>{
    public int compare(Integer o1 , Integer o2){
        int unit1 = o1%10;
        int unit2 = o2%10;
        if(unit1<unit2){
            return -1;
        }else{
            return 1;
        }
    }
}
public class unitplaceSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(100);
        arr.add(67);
        arr.add(93);
        arr.add(55);
        arr.add(121);
        arr.add(9);
        Collections.sort(arr,new cmp());
        System.out.println(arr);

    }
}