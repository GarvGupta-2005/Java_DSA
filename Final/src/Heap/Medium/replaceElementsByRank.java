package Heap.Medium;

import java.util.*;

public class replaceElementsByRank {
// Copy all the elements of the array in a dummy array.
// Sort the dummy array.
// Take a variable temp to calculate the rank of each element.Initially the value of temp is 1.
// Maintain a map to store the rank of each element.
// Now traverse through the dummy array,if element is previously not stored in map then store the value of element with the temp and then increament temp.
// Now traverse through the original array and print the rank of that corresponding element using map.


public static void main(String args[]) {
    int arr[] = {20,15,26,2,98,6};
    HashMap < Integer, Integer > mp = new HashMap<>();
    int temp = 1;
    int n = arr.length;
    int brr[] = new int[n];
    for (int i = 0; i < n; i++) {
      brr[i] = arr[i];
    }
    Arrays.sort(brr);
    for (int i = 0; i < n; i++) {
      //if element is previously not store in the map
      if (mp.get(brr[i]) == null) { //This step will work for duplicate elements as the rank is only increased if the value is previoulsy not in the map
        mp.put(brr[i], temp);
        temp++;
      }
    }
    for (int i = 0; i < n; i++) {
      System.out.print(mp.get(arr[i]) + " ");
    }
  }


  //This is an approach using Priority Queue
  static int[] replaceWithRank(int arr[], int N) {
    // code here
   PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
   int ind=0;
   int prev=-1;
   for(int i: arr)
   {
       pq.add(new int[]{i,ind});
       ind++;
   }
   int u=0;
   while(!pq.isEmpty())
   {
       int yr[] = pq.poll();
       if(prev!=yr[0])
           u++;
       arr[yr[1]]=u;
       prev=yr[0];
   }
   return arr;
 }

}
