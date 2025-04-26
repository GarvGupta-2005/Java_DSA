package Array.MediumLevel;

public class majority {
    public int majorityElement(int[] nums) {
        //The Better Solution is to use a hashmap and then retain frequenct that matches iur answe O(nlogn)
        //The optimal solution is Moore's Voting Algorithm which checks if the counter is increaing than n/2
        int cnt =0;
        int ele = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(cnt==0){
                cnt=1;
                ele = nums[i];
            }
            else if(nums[i]==ele){
                cnt++;
            }else{
                cnt--;
            }
        } 
        int cnt1 = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==ele){cnt1++;}
        }
        if(cnt1 > (nums.length/2)){
            return ele;
        }
        return -1;
    }
}
