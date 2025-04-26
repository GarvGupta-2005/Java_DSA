package BinarySearch.Answers_SearchSpace;

import java.util.*;

public class allocateBooks {
    //The maximum no. of pages should be minimum
    //in these kinf of BS problems , few important points 
    // 1. The low and the high
    // 2. The function that will check whether this can be the anser or not

//The low will be the maximum no. of pages as that can be lowest pages one can have in the example
// [25,46,28,49,24] the low will be 49 as at each index the first guy will thimk i can take 25 pages and then try for next book as max pages is 49
//but if we had taken 24 as low then we couldn't have taken 28 pages book since max limit is 24
//The high will be the sum of elements as if we had one student then all books would go to that one guy
//The answer will always be -1 when the number of books is less than the number of students since not every student will get a single book

public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
