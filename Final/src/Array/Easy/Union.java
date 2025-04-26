package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class Union {
    public static List< Integer > sortedArray(int []arr1, int []arr2) {
        // Write your code here
        int i = 0, j = 0; // pointers
        int n = arr1.length;
        int m = arr2.length;
        List<Integer> Union = new ArrayList<>(); // Union list

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) { // Case 1 and 2
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else { // Case 3
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }

        while (i < n) { // If any elements are left in arr1
            if (Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        while (j < m) { // If any elements are left in arr2
            if (Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }

        
        return Union;
    }
}
