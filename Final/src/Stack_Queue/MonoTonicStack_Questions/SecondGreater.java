package Stack_Queue.MonoTonicStack_Questions;

import java.util.Arrays;
import java.util.Stack;

public class SecondGreater {
    public int[] secondGreaterElement(int[] arr) {
        int n = arr.length;
        int [] ans = new int[n];//tores the second greatest to the right
        Arrays.fill(ans,-1);
        //We will use two stacks
        //One will store those elements whose we have not found even the first greater
        //Second will store those elements whose first greater has been found

        Stack<Integer> st1 = new Stack<>();// elements whose we have not found even the first greater
        Stack<Integer> st2 = new Stack<>();//elements whose first greater has been found


        for(int i = 0;i<n;i++){
            ///What are the elements for which arr[i] is the second greater
            while(!st2.isEmpty() && arr[i]> arr[st2.peek()]){
                ans[st2.peek()] = arr[i];
                st2.pop();
            }
            Stack<Integer> temp = new Stack<>();
            //The temp stack is used to maintan the order in which they were entered in st1
            while(!st1.isEmpty() && arr[i] > arr[st1.peek()]){
                temp.push(st1.peek());
                st1.pop();
            }
            //Putting them in the same order in the st2
            while(!temp.isEmpty()){
                st2.push(temp.peek());
                temp.pop();
            }
            st1.push(i);
        }

        return ans;
    }
}
