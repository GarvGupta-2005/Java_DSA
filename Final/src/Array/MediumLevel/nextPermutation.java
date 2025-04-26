package Array.MediumLevel;

import java.util.Arrays;
//All time favourite question
public class nextPermutation {
    public void reverse(int [] array ,int i,int j){
        
        while(i<j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
    public void NextPermutation(int[] nums) {
        int index1 = -1;//placevalue where swapping value is found
        for(int i = nums.length-1;i>=1;i--){
            if(nums[i-1]<nums[i]){
                index1 = i-1;
                break;
            }
        }
        if(index1 == -1){
            Arrays.sort(nums);
            return;
        }
        int index2 = -1;//placevalue where swap is to be done
        for(int i = nums.length-1;i>index1;i--){
            if(nums[i]>nums[index1]){
                index2 = i;
                break;
            }
        }
        int temp = nums[index1];
        nums[index1]=nums[index2];
        nums[index2] = temp;
        reverse(nums,index1+1,nums.length-1);

    }
}
