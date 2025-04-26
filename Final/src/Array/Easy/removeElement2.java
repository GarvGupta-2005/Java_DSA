package Array.Easy;

public class removeElement2 {
        public  static int removeElement(int[] nums, int val) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[index] = nums[i];  // Just iterate through the array and place all non target values in their correct order as we have to place all the non-target values 
                    //Common sense use that we don't have to remove the element 
                    index++;
                }
            }
            return index;
        }
    
}
