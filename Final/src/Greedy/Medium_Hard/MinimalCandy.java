package Greedy.Medium_Hard;

public class MinimalCandy {
    public static int candy(int[] ratings) {
        // //The brute Approach is to take a left and right array and iterate for both
        // //left and right neighbours and then take max for both left[i] and right[i]
        // int n = ratings.length;
        // int [] left = new int[n];
        // int [] right = new int[n];
        // left[0] = 1;
        // right[n-1] = 1;
        // for(int i = 1;i<n;i++){
        //     if(ratings[i]>ratings[i-1]){
        //         left[i] = left[i-1] + 1;
        //     }else{
        //         left[i] = 1;
        //     }
        // }

        // for(int i = n-2;i>=0;i--){
        //     if(ratings[i+1]<ratings[i]){
        //         right[i] = right[i+1]+1;
        //     }else{
        //         right[i] = 1;
        //     }
        // }
        // int ans = 0;
        // for(int i = 0;i<n;i++){
        //     ans += Math.max(left[i],right[i]);
        // }
        // return ans;

        //The optimal approach is something to know in advance or you can't solve it
        int sum = 1;
        int n = ratings.length;
        int i = 1;
        while(i<n){
            if(ratings[i] == ratings[i-1]){
                sum+=1;
                i++;
            }
            int peak = 1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak+=1;
                sum+=peak;
                i++;
            }
            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+=down;
                i++;
                down++;
            }
            if(down>peak){
                sum+= down-peak;
            }
        }
        return sum;
    }
}