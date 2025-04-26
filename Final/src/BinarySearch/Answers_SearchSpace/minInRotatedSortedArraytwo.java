package BinarySearch.Answers_SearchSpace;
public class minInRotatedSortedArraytwo {
        public int findMin(int[] arr) {
            //The condition that prevents us from findinig the correct half is a[low]==a[mid]==a[high]
    //For instance if arr [] = [3,1,2,3,3,3,3,]
    //Thus we have to elminat ethis condition 
            
    //...........................................................................................
    
            //The key point is to identify the sorted half as one side of mid can be sorted and one side can be not
            int n = arr.length;
            int low = 0;
            int high = n-1;
            int ans = Integer.MAX_VALUE;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                    low++;
                    high--;
                    ans = Math.min(ans,arr[mid]);
                    continue;
                }//To eliminate the unnecceasry condition 
               
    if(arr[low]<=arr[mid]){
                    ans = Math.min(ans,arr[low]);
                    low = mid + 1;
                }else{
                    ans = Math.min(ans,arr[mid]);
                    high = mid - 1;
                }
    
            }
            return ans;
        }
    }
