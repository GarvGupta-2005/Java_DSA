package Array.Easy;

import java.util.*;

// import java.util.*;
public class SecondthMax_Min {
    public static int[] getSecondOrderElements(int n, int []arr) {
        // Write your code here.
        Arrays.sort(arr);
        if(n<2){
            int [] a = new int[2];
            a[0]= -1;
            a[1] = -1;
            return a;
        }
        int large = Integer.MIN_VALUE;
    	int second_large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
	    int second_small = Integer.MAX_VALUE;
	int i;
	for (i = 0; i < n; i++)
	{
		if (arr[i] > large)
		{
			second_large = large;
			large = arr[i];
		}

		else if (arr[i] > second_large && arr[i] != large)
		{
			second_large = arr[i];
		}
        //
        if (arr[i] < small)
	   {
		  second_small = small;
		  small = arr[i];
	   }
	   else if (arr[i] < second_small && arr[i] != small)
	   {
		  second_small = arr[i];
	   }
	}

        int [] ans = new int[2];
        ans[0] = second_large;
        ans[1] = second_small;
        return ans;
    }
}