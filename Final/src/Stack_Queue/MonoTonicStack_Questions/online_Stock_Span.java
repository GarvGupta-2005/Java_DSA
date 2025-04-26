package Stack_Queue.MonoTonicStack_Questions;

import java.util.Stack;

public class online_Stock_Span {
    class Pair{
    int value;
    int index;
    Pair(int value,int index){
        this.value = value;
        this.index = index;
    }
}
class StockSpanner {
    //The Brute Force is to maintain a list and go till the first element counting which are less than or eqaul to today
    //A pseudocode of that looks like
    // int func(int val){
   //    list.add(val);
   // int count  = 1;
//  for(int i = list.length()-2;i>=0;i++){
//    if(list.get(i)<= list.get(list.length()-1)){
//        count++;
//    }
//} 
//   return count;
    //}

    //The Optimal way is use Previous Gretaer Element Index and then current_index - previous_greater_index = span;
    Stack<Pair> st;
    int i;
    public StockSpanner() {
        st = new Stack<>();
        i = -1;
    }
    
    public int next(int price) {
        i+=1;
        while(!st.isEmpty() && st.peek().value <= price){
            st.pop(); //Removing all the elements smaller or less than the current price;
        }

      int ans = st.isEmpty() ? i + 1 : i - st.peek().index;//Calculating the answer 
   //If the stack is empty then all the elements were shorter than current index and thus the answer is current index + 1
//Else if it is not empty then current index - Element greter index is the answer
        st.push(new Pair(price,i));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
