package Stack_Queue.MonoTonicStack_Questions;


import java.util.*;
public class nextGreaterElement2 {
    //This Nect Gretaest Element in a circular Array is used to find NGE in a circle by Using the modulo operation
    //We will assume that the Array is doubled like for example a = [2,10,12,1,11] then virtual double array is = [2,10,12,1,11,2,10,12,1,11]
    //We will find the NGE for whole arrray and set in array for those elements having indices less than n

    public static int [] NGE2(int [] a){
        int []  ans = new int [a.length];
        Stack<Integer> st = new Stack<>();

        int n = a.length;
        for(int i = 2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=a[i%n]){
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()){
                ans[i] = -1;
                }else{
                 ans[i] = st.peek();
                }
            }
            st.push(a[i%n]);
        }
        return ans;
    }
}
