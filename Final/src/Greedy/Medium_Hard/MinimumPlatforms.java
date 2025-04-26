package Greedy.Medium_Hard;

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[]) {
        
        //The brute approach is to go to each train and look for in future which train is 
        //arriving and which is leavinng thus eading to O(N^2)
    //     int ans=1; //final value
    // for(int i=0;i<=n-1;i++)
    // {
    //     int count=1; // count of overlapping interval of only this   iteration
    //     for(int j=i+1;j<=n-1;j++)
    //     {
    //         if((arr[i]>=arr[j] && arr[i]<=dep[j]) ||
    //       (arr[j]>=arr[i] && arr[j]<=dep[i]))
    //       {
    //           count++;
    //       }
    //     }
    //     ans=Math.max(ans,count); //updating the value
    // }
    // return ans;
    
    //The optimal approach is to sort the both arrays and keep one pointer on arr and dep
    //keep moving towards the lower value and keep increaing the count of number of arr
    // in the end we will have the maximum intersections for each 
    
    Arrays.sort(arr);
    Arrays.sort(dep);
    int n = arr.length;
    int count  = 0;
    int maxcount = 0;
    int i = 0 , j = 0;
    while(i<n){
        if(arr[i]<=dep[j]){
            i++;
            count++;
        }else{
            count--;
            j++;
        }
        maxcount = Math.max(maxcount,count);
    }
    
    return maxcount;
    }
}
