package Array.Hard;

import java.util.ArrayList;
import java.util.List;

//The brute force approach is to go over each elemen  agian and to find its count o(n^2)
//The better approach is to hashmap which we have done in LEETOCODE
public class Majorit2 {
    //One observation to be made is that only 2 elements will be there that will appear more than |n/3| times because let us say ther are 8 elements 
    //in total so floor division 8/3 = 2 
    //So the elements can appear more than twice . Say 1 element appears 3 times 
    //Another element appears 3 times 
    // ANother element appear thrice which is not possible as 3+3+3 = 9 but we have only 8 elements Therefore Only 2 elemnts will appaer more then |n/3| times
    

    public static List<Integer> getMajority(int [] v){
        int n = v.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != v[i]) {
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            } else if (v[i] == el1) cnt1++;
            else if (v[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1) cnt1++;
            if (v[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return ls;
    }
}
