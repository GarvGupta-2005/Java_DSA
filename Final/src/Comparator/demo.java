package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class demo {

    public static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer i , Integer j){
                if(i > j){
                    return -1; // to not sort 
                }else{
                    return 1; // to sort
                }
            }
        };
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(90);
        Collections.sort(a,cmp);
        System.out.println(a);
    }
}