package Array.Hard;
import java.util.*;
public class TupleWithEqualSum {
    
}
class Solution {
    //This is a very intutive question for the first time. You require maths for this question 
    //We don't have to form all the permutations we just have to count all the permuations
    //We have to count all the profucts and check the number of selections and permutations 
    // for instance a*b has 2 permutations , c*d has 2 permutations and and they over all has 2
    //Thus we have 2*2*2 permutations i.e 8 permutations 
    // and now we have to select 2 from n thus ans += nC2*8 where n is the total frequency of pro
    //nC2 = n!/n-2!*2! => n(n-1)/2 * 8 = 4n*(n-1) this formula is the onw we will be using 
    
    
        public int tupleSameProduct(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();//For stroing product and frequency
    
    //For stroing all the unique products along with their frequencies
            for(int i = 0;i<nums.length;i++){
                for(int j = i+1;j<nums.length;j++){
                    int product = nums[i]*nums[j];
                    if(map.containsKey(product)){
                        map.put(product,map.get(product)+1);
                    }else{
                        map.put(product,1);
                    }
                }
            }
    
            int ans = 0;
            return ans;
        }
    
    }
