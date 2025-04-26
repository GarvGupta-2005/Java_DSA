package Stack_Queue.MonoTonicStack_Questions;

import java.util.Stack;

public class numberOfGreaterElementsinqueries {

    //It was idiotic to think about any other any explaination when you just have to run brute approach
    //We didi here same for each query index we just iterated from last to that index and counted elements greater than it
  public static int[] count_NGEs(int n, int arr[], int q, int indices[]) {
      
    int [] ans= new int[q];
      for(int i=0;i<q;i++){
          int curr=arr[indices[i]];
          Stack<Integer> st = new Stack<>();
          int r=n-1;
          while(r>indices[i]){
              if(arr[r]>curr){
                  st.push(arr[r]);
              }
              r--;
          }
          ans[i]=st.size();
      }
      return ans;
     
  }

}
