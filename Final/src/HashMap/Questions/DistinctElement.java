package Questions;
import java.util.HashMap;
public class DistinctElement {     // Given an array we have to find the frequency of all distinct elements
    public  static void distinct(int [] arr){
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i = 0; i < arr.length;i++){
            if(h.containsKey(arr[i])){
                int old_fre = h.get(arr[i]);
                h.put(arr[i], old_fre+1); // If the value is encountered again 
            }else{
                h.put(arr[i],1);  // if the value is encounterd for first time
            }
        }
        for(Integer key:h.keySet()){
            System.out.println(key+" "+h.get(key));//keyset is used to get all the keys of the hashmap in a set like structure to itertate  
        }
    }
    public static void main(String[] args) {
        int arr [] = {1,6,3,6,2,3,1,6};
        distinct(arr);
    }
}
