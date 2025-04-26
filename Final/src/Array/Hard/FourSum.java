package Array.Hard;

import java.util.*;

public class FourSum {
    //The brute approach is to run four loops and to get our answer : not a good approach O(n^4)
        //Better approach run three loops and find nums[d] = target - (nums[a]+nums[b]+nums[c]) O(n^3)
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length; // size of the array
//         Set<List<Integer>> st = new HashSet<>();

//         // checking all possible quadruplets:
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 Set<Long> hashset = new HashSet<>();
//                 for (int k = j + 1; k < n; k++) {
//                     // taking bigger data type
//                     // to avoid integer overflow:
//                     long sum = nums[i] + nums[j];
//                     sum += nums[k];
//                     long fourth = target - sum;
//                     if (hashset.contains(fourth)) {
//                         List<Integer> temp = new ArrayList<>();
//                         temp.add(nums[i]);
//                         temp.add(nums[j]);
//                         temp.add(nums[k]);
//                         temp.add((int) fourth);
//                         temp.sort(Integer::compareTo);
//                         st.add(temp);
//                     }
//                     // put the kth element into the hashset:
//                     hashset.add((long) nums[k]);
//                 }
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>(st);
//         return ans;
//     }

//The optimal approach is to fix two pointers like we did to i in 3Sum problem and then iterate over enyire array to find the required sum of 0
//This will reduce the space required by set and hashmap and reduce comlexity from O(n^3logn) to O(n^3)
public List<List<Integer>> fourSum(int[] nums, int target) {
    int n = nums.length; // size of the array
   List<List<Integer>> ans = new ArrayList<>();

   // sort the given array:
   Arrays.sort(nums);

   // calculating the quadruplets:
   for (int i = 0; i < n; i++) {
       // avoid the duplicates while moving i:
       if (i > 0 && nums[i] == nums[i - 1]) continue;
       for (int j = i + 1; j < n; j++) {
           // avoid the duplicates while moving j:
           if (j > i + 1 && nums[j] == nums[j - 1]) continue;

           // 2 pointers:
           int k = j + 1;
           int l = n - 1;
           while (k < l) {
               long sum = nums[i];
               sum += nums[j];
               sum += nums[k];
               sum += nums[l];
               if (sum == target) {
                   List<Integer> temp = new ArrayList<>();
                   temp.add(nums[i]);
                   temp.add(nums[j]);
                   temp.add(nums[k]);
                   temp.add(nums[l]);
                   ans.add(temp);
                   k++;
                   l--;

                   // skip the duplicates:
                   while (k < l && nums[k] == nums[k - 1]) k++;
                   while (k < l && nums[l] == nums[l + 1]) l--;
               } else if (sum < target) k++;
               else l--;
           }
       }
   }

   return ans;
}
}
