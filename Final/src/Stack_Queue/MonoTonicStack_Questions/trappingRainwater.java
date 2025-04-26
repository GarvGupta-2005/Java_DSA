package Stack_Queue.MonoTonicStack_Questions;

public class trappingRainwater {
    //A pretty tough question so make sure to revise it thoroughly 

    //The thing to note is that we can store water at a point if it has two taller buildings on its left and right side
    //The maximum hieght of water that can be stored is the minimum of leftHieght and rightHieght
    //Also we need to subtract the hieght of curent building as it cannot be included in the amount of water stored
    //Thus a formula kind of hing for current point  = Math.min(leftHieght,rightHieght) - arr[i];
    //This can be done in two ways either using prefix and suffix arrays or using stack based DS

    public static int trap1(int[] hieght) {
        int total = 0;
        int n = hieght.length;
        int [] prefix = new int[n];
        int [] suffix = new int[n];
        //First calculating left max or prefix
        prefix[0] = hieght[0];
        for(int i = 1;i<n;i++){
            prefix[i] = Math.max(hieght[i],prefix[i-1]);
        }
        //Calculating righ max or suffix
        suffix[n-1] = hieght[n-1];
        for(int i = n-2;i>=0;i--){
            suffix[i] = Math.max(hieght[i],suffix[i+1]);
        }
        //Now calculating the total answer
        for(int i = 0;i<n;i++){
            total += Math.min(prefix[i],suffix[i])-hieght[i];
        }
        return total;
    }

    //Approach Optimal
//Take 2 pointers l(left pointer) and r(right pointer) pointing to 0th and (n-1)th index respectively. Take two variables leftMax and rightMax and initialize them to 0. If height[l] is less than or equal to height[r] then if leftMax is less than height[l] update leftMax to height[l] else add leftMax-height[l] to your final answer and move the l pointer to the right i.e l++. If height[r] is less than height[l], then now we are dealing with the right block. If height[r] is greater than rightMax, then update rightMax to height[r] else add rightMax-height[r] to the final answer. Now move r to the left. Repeat these steps till l and r crosses each other.

// Intuition: We need a minimum of leftMax and rightMax.So if we take the case when height[l]<=height[r] we increase l++, so we can surely say that there is a block with a height more than height[l] to the right of l. And for the same reason when height[r]<=height[l] we can surely say that there is a block to the left of r which is at least of height[r]. So by traversing these cases and using two pointers approach the time complexity can be decreased without using extra space.

static int trap(int[] height) {
    int n = height.length;
    int left = 0, right = n - 1;
    int res = 0;
    int maxLeft = 0, maxRight = 0;
    while (left <= right) {
        if (height[left] <= height[right]) {
            if (height[left] >= maxLeft) {
                maxLeft = height[left];
            } else {
                res += maxLeft - height[left];
            }
            left++;
        } else {
            if (height[right] >= maxRight) {
                maxRight = height[right];
            } else {
                res += maxRight - height[right];
            }
            right--;
        }
    }
    return res;
}

}

