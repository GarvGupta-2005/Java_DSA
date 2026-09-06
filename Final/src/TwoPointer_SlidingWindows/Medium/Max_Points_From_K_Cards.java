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

    //Approach 2 
    public int maxScore2(int[] cardPoints, int k) {
        //Given we have to find the maxScore with k cards from any side
        //Visualize that if we take K cards from any end, we will leave an contigous part of size n-k 
        //What if we find that window of n-k size which will reduce the minimum score, 
        //So our algo will be to find the window which has the min reduction 

        int n = cardPoints.length;
        k = n-k;
        int ans = 0;

        int total = 0;
        for(int x : cardPoints){
            total += x;
        }

        int current = 0;

        //first window 
        for(int i = 0;i<k;i++){
            current += cardPoints[i];
        }

        ans = Math.max(ans,total-current);

        int last = 0;
        for(int i = k;i<n;i++){
            current = current + cardPoints[i] - cardPoints[last];
            ans = Math.max(ans,total-current);
            last++;
        }

        return ans;
    }
}
