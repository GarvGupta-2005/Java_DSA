package Array.MediumLevel;

public class Positive_NegativeArrangement {
    public int[] rearrangeArray(int[] nums) { //This is to be done in order
        //This approach is the optimal by far
        //The better approach is to divide the array in 2 halves fill obe with negative and one with   postive and then fill the final array  
        int n = nums.length;
        int [] ans = new int[n];
        int pos = 0,neg = 1;
        for(int i = 0; i <n ; i++){
            if(nums[i]<0){
                ans[neg] = nums[i];
                neg+=2;
            }else{
                ans[pos] = nums[i];
                pos+=2;
            }
        }
        return ans;
    }
}
