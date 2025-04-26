package Stack_Queue.MonoTonicStack_Questions;

import java.util.Stack;

public class LargestRectangleinHistogram {
    //The ractangle can be formed until the smaller element on each side is encountered. This will help in formong the rectangle
//Thus, we need to find the Next Smaller Element Index and Previous Smaller Element Index


public int[] nextSmallerElementIndex(int [] a){
    int [] res = new int[a.length];
    Stack<Integer> st = new Stack<>();
    for(int i = a.length-1;i>=0;i--){
        while(!st.isEmpty() && a[st.peek()]>=a[i]){
            st.pop();
        }
        if(st.isEmpty()){
            res[i] = a.length;
        }else{
            res[i] = st.peek();
        }
        st.push(i);
    }
    return res;
}
public int[] previousSmallerElementIndex(int [] a){
    int [] res = new int[a.length];
    Stack<Integer> st = new Stack<>();
    for(int i = 0;i<a.length;i++){
        while(!st.isEmpty() && a[st.peek()]>=a[i]){
            st.pop();
        }
        if(st.isEmpty()){
            res[i] = -1;
        }else{
            res[i] = st.peek();
        }
        st.push(i);
    }
    return res;
}

    public int largestRectangleArea(int[] hei) {
        int [] nse = nextSmallerElementIndex(hei);
        int [] pse = previousSmallerElementIndex(hei);
        int res = 0;
        for(int i = 0;i<hei.length;i++){
            res = Math.max(res,hei[i]*(nse[i]-pse[i]-1));
        }
        return res;
    }
    //But this a Bute Approach as it takes a lot of loops and TC of O(5n) one for main function , O(2n) for previous smaller element index and O(2n) for nextSmallerElementIndex

    //The Above approach can be optimized by calculating nse and pse at the fly that is calculating it side by side to re
    public int largestRectangleArea1(int[] histo) {
        Stack < Integer > st = new Stack < > ();
         int maxA = 0;
         int n = histo.length;
         for (int i = 0; i <= n; i++) {
             while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {  //This whole while loop is used to calculate The next smaller element
                 int height = histo[st.peek()]; //If its true then the current element of i is the nse of statck's top element and we will calculate max area for for stack's top
                 st.pop();
                 int width;
                 if (st.empty())   
                 width = i;
                 else
                     width = i - st.peek() - 1;
                 maxA = Math.max(maxA, width * height);
             }
             st.push(i);
         }
         return maxA;
     }
}
