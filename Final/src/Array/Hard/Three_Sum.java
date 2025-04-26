package Array.Hard;

import java.util.*;

public class Three_Sum {
//     public List<List<Integer>> threeSum(int[] arr) {
//         //The brute force approach is to run three nested loops from i , j=i+1,k=j+1 to find triplets but this O(n^3)
//         //The better apporach is to use HashMap where we store and find the values as if it contains x-nums[i] and so that this will take o((n^2)logn) as we will still require two loops to srore two values and then find if map contains (arr[k] =  0 - (arr[i]+arr[j]))

//     Set<List<Integer>> st = new HashSet<>();
// int n = arr.length;
//         for (int i = 0; i < n; i++) {
//             Set<Integer> hashset = new HashSet<>();
//             for (int j = i + 1; j < n; j++) {
//                 //Calculate the 3rd element:
//                 int third = -(arr[i] + arr[j]);

//                 //Find the element in the set:
//                 if (hashset.contains(third)) {
//                     List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
//                     temp.sort(null);
//                     st.add(temp);
//                 }
//                 hashset.add(arr[j]);
//             }
//         }

//         // store the set elements in the answer:
//         List<List<Integer>> ans = new ArrayList<>(st);
//         return ans;
//     }

//The Most optimal approach
public List<List<Integer>> threeSum(int[] arr) {
    //In this approach we literally  fix the pointer i and move the pointers j and k according to our sum being formed as we will sort the array 
    //This gives us an algo for O(n^2) 
    int n = arr.length;
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(arr);

    for (int i = 0; i < n; i++) {
        //remove duplicates:
        if (i != 0 && arr[i] == arr[i - 1]) continue;

        //moving 2 pointers:
        int j = i + 1;
        int k = n - 1;
        while (j < k) {
            int sum = arr[i] + arr[j] + arr[k];
            if (sum < 0) {
                j++;
            } else if (sum > 0) {
                k--;
            } else {
                List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                ans.add(temp);
                j++;
                k--;
                //skip the duplicates:
                while (j < k && arr[j] == arr[j - 1]) j++;
                while (j < k && arr[k] == arr[k + 1]) k--;
            }
        }
    }

    return ans;
}
}
