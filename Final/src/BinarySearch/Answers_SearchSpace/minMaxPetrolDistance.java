package BinarySearch.Answers_SearchSpace;
// import java.util.*;
public class minMaxPetrolDistance {
    //This problem has 2 optimal solutions
    //1. Using Heap
    //2. Using BS
    //Algo for heap
//     First, we will declare an array ‘howMany[]’ of size n-1, to keep track of the number of placed gas stations and a priority queue that uses max heap.
// We will insert the first n-1 indices with the respective distance value, arrr[i+1]-arr[i] for every index.
// Next, using a loop we will pick k gas stations one at a time.
// Then we will pick the first element of the priority queue as this is the element with the maximum distance. Let’s call the index ‘secInd’.
// Now we will place the current gas station at ‘secInd’(howMany[secInd]++) and calculate the new section length,
// new_section_length = initial_section_length / (number_of_stations_ inserted+1)
//             = (arr[secInd+1] - arr[secInd]) / (howMany[i] + 1)
// After that, we will again insert the pair <new_section_length, secInd> into the priority queue for further consideration.
// After performing all the steps for k gas stations, the distance at the top of the priority queue will be the answer as we want the maximum distance.
    // public static class Pair {
    //     double first;
    //     int second;

    //     Pair(double first, int second) {
    //         this.first = first;
    //         this.second = second;
    //     }
    // }
    // public static double MinimiseMaxDistance(int []arr, int K){
    //     // Write your code here.
    //     int n = arr.length; // size of array.
    //     int[] howMany = new int[n - 1];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

    //     // insert the first n-1 elements into pq
    //     // with respective distance values:
    //     for (int i = 0; i < n - 1; i++) {
    //         pq.add(new Pair(arr[i + 1] - arr[i], i));
    //     }

    //     // Pick and place k gas stations:
    //     for (int gas = 1; gas <= K; gas++) {
    //         // Find the maximum section
    //         // and insert the gas station:
    //         Pair tp = pq.poll();
    //         int secInd = tp.second;

    //         // insert the current gas station:
    //         howMany[secInd]++;

    //         double inidiff = arr[secInd + 1] - arr[secInd];
    //         double newSecLen = inidiff / (double) (howMany[secInd] + 1);
    //         pq.add(new Pair(newSecLen, secInd));
    //     }

    //     return pq.peek().first;
    // }

    //BS Approach 
    
        //Now in this BS approach we will use som mathematical observations and conditions to deive a formula and then we will applye BS and will find our answer
    // here we will be forming combinations from both array that how many elements from which array will go to left of median and same for right 
    //This will require a valid symmetry among the elements of each array 
    // for instance if we have two arrays as a1[1,3,4,7,10,12] and a2[2,3,6,15] the valid symmetry will be 
    // 1 3 4(l1) | 7(r1) 10 12
    //    2 3(l2) | 6(r2) 15   //in here the diagonal 4 is less than 6 and diagonal 3 is less than 7 so its a valid
    //The answer will be [max(l1,l2)+min(r1,r2)]/2; for even total length
    //The answer for odd total length is max(l1,l2);
    //Now the BS will find how many elements from which array has to be chosen
    //if l1>r2 high = mid - 1; eliminate right
    //else if r1<l2 left = mid + 1 ; eliminate right half

    // The algo is as follows:
//     First, we have to make sure that the arr1[] is the smaller array. If not by default, we will just swap the arrays. Our main goal is to consider the smaller array as arr1[].
// Calculate the length of the left half: left = (n1+n2+1) / 2.
// Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 0 and the high will point to n1(i.e. The size of arr1[]).
// Calculate the ‘mid1’ i.e. x and ‘mid2’ i.e. left-x: Now, inside the loop, we will calculate the value of ‘mid1’ using the following formula:
// mid1 = (low+high) // 2 ( ‘//’ refers to integer division)
// mid2 = left-mid1
// Calculate l1, l2, r1, and r2: Generally,
// l1 = arr1[mid1-1]
// l2 = arr2[mid2-1]
// r1 = arr1[mid1]
// r2 = arr2[mid2]
// The possible values of ‘mid1’ and ‘mid2’ might be 0 and n1 and n2 respectively. So, to handle these cases, we need to store some default values for these four variables. The default value for l1 and l2 will be INT_MIN and for r1 and r2, it will be INT_MAX.
// Eliminate the halves based on the following conditions:
// If l1 <= r2 && l2 <= r1: We have found the answer.
// If (n1+n2) is odd: Return the median = max(l1, l2).
// Otherwise: Return median = (max(l1, l2)+min(r1, r2)) / 2.0
// If l1 > r2: This implies that we have considered more elements from arr1[] than necessary. So, we have to take less elements from arr1[] and more from arr2[]. In such a scenario, we should try smaller values of x. To achieve this, we will eliminate the right half (high = mid1-1).
// If l2 > r1: This implies that we have considered more elements from arr2[] than necessary. So, we have to take less elements from arr2[] and more from arr1[]. In such a scenario, we should try bigger values of x. To achieve this, we will eliminate the left half (low = mid1+1).
// Finally, outside the loop, we will include a dummy return statement just to avoid warnings or errors.
// The steps from 4-6 will be inside a loop and the loop will continue until low crosses high.
        public double findMedianSortedArrays(int[] a, int[] b) {
            int n1 = a.length, n2 = b.length;
            //if n1 is bigger swap the arrays:
            if (n1 > n2) return findMedianSortedArrays(b, a);
    
            int n = n1 + n2; //total length
            int left = (n1 + n2 + 1) / 2; //length of left half
            //apply binary search:
            int low = 0, high = n1;
            while (low <= high) {
                int mid1 = (low + high) / 2;
                int mid2 = left - mid1;
                //calculate l1, l2, r1 and r2;
                int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
                int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
                int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
                int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
    
                if (l1 <= r2 && l2 <= r1) {
                    if (n % 2 == 1) return Math.max(l1, l2);
                    else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                } else if (l1 > r2) high = mid1 - 1;
                else low = mid1 + 1;
            }
            return 0; //dummy statement
        }
    
}
