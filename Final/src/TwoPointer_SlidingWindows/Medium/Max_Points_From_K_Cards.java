package TwoPointer_SlidingWindows.Medium;

public class Max_Points_From_K_Cards {
    public int maxScore(int[] cardPoints, int k) {
        //The approach is to take two variables leftSum and rightSum and taking values one by one from each end and total sum = 0;
        //First we will take leftSum as first k elements and right sum as 0
        //Then we will take k-1 elements from the left and 1 element from the end and take their sum for maxSum candidtae 
        //then so on we will take values until we take 0 values from left and k values from the end
        
        int leftSum = 0,rightSum = 0;
        int maxSum = 0;
        int n = cardPoints.length;
        for(int i = 0;i<k;i++){
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;
        int r = n-1;
        for(int i = k-1;i>=0;i--){
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[r];
            maxSum = Math.max(maxSum,leftSum+rightSum);
            r--;
        }
        return maxSum;
    }
}
