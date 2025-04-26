package Questions;
import java.util.*;
class Solution {
    public ArrayList<String> distinctOnes(String[] a){
        HashMap<String , Integer> hm = new HashMap<>();
        for(int i = 0;i<a.length;i++){
            if(hm.containsKey(a[i])){
                Integer old_fre = hm.get(a[i]);
                hm.put(a[i],old_fre+1);
            }else{
                hm.put(a[i],1);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for(String key:hm.keySet()){
            if(hm.get(key)==1){
                res.add(key);
            } 
        }
        return res;
    }
    public String kthDistinct(String[] arr, int k) {
        ArrayList<String> temp = distinctOnes(arr);
        if(temp.size()<k){
            return "";
        }else{
            return temp.get(k-1);
        }
    }
}
