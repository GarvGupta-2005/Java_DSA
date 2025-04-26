package Recursion.Hard;

import java.util.*;
public class VivekArrayGame {
    public static int maxPoints(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        
        int totalSum = 0;
        for (int i = start; i <= end; i++) {
            totalSum += arr[i];
        }
        
        int leftSum = 0;
        for (int i = start; i < end; i++) {
            leftSum += arr[i];
            int rightSum = totalSum - leftSum;//Removing leftSUm from total
            
            if (leftSum == rightSum) {
                return 1 + Math.max(maxPoints(arr, start, i), maxPoints(arr, i + 1, end));
            }
        }
        
        return 0;
    }
    
    public static int findMaxScore(int[] arr) {
        return maxPoints(arr, 0, arr.length - 1);
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0){
            int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(findMaxScore(arr));
        }
    }
}
