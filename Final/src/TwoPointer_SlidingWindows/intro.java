package TwoPointer_SlidingWindows;

public class intro {
    //We will see 4 different kinds of patterns regarding slidingwindows and twopointer approach:
    //1. Constant Window
    //Suppose we are given an array and we are given a winodw size k and we have to find the maxSum of k continous elements
    // let a = [-1,2,3,3,4,5,-1] and k = 4 then take l = 0; and r = k-1 for the initial window sum = 7
    //then for the next window first decrease the value of a[l] from the sum and then increment l and r and then take new window sum that is -1 + 2 + 3 + 3 -(-1) + 4 = 12
    
    //2. Longest Subarray/Substring where <condition> this is the most common type of problem in this approach
    //This can have Brute Solution then Better solution and then finally The Optimal Solution
    //For example In this array find the Longest Subaray with sum<=k
    // a=[2,5,1,7,10] & k = 14
    //Brue will be to generate all the subarrays and check their sum leading to O(n^2)
    //Note expansion happens for r and shirk happens for l and the size of window 
    //Wheb the sum is within k we expand that is r++ but when the sum exceeds k we shrink that is l++ and resuce the sum by a[l]

    //3. Figure out the no. of subarrays with a cerain condition
    //4. Shortest?minimum window with a certain condition
}
