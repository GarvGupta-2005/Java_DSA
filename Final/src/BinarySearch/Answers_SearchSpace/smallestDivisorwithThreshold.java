package BinarySearch.Answers_SearchSpace;

public class smallestDivisorwithThreshold {
    
        public static boolean isDivisionPossible(int [] arr,int divisor, int limit){
            // double x = 1.0 / 4; // Perform floating-point division
            // x = Math.ceil(x);   // Apply ceil to the result
            // System.out.println((int)x); // Convert the result back to int if needed
    
            int sum = 0;
            for(int i = 0;i<arr.length;i++){
                double x = arr[i]*1.0;
                x = x/divisor;
                x = Math.ceil(x);
                sum = sum + ((int)x);
                if(sum>limit){
                    return false;
                }
            }
            if(sum<=limit){
                return true;
            }else{
                return false;
            }
        }
        public static  int smallestDivisor(int[] arr, int limit) {
            int low  = 1;
                int high = Integer.MIN_VALUE;
                int ans = -1;
                int n = arr.length;
                for(int i = 0;i<n;i++){
                    
                    if(arr[i]> high){
                        high = arr[i];
                    }
                }
            while(low<=high){
                int mid = low + (high-low)/2;
                if(isDivisionPossible(arr,mid,limit)){
                    ans = mid;
                    high = mid - 1;
                }else{
                    low  = mid + 1;
                }
            }
            return ans;
        }
    }

