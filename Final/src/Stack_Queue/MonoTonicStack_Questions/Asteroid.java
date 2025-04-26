package Stack_Queue.MonoTonicStack_Questions;

import java.util.Stack;

public class Asteroid {
    //The trick is the sign of the Asteroid and its value. If the Sign is opposite then the value then smaller one will vanish. If they have equal values but opposite sign then both will vanish. If they have same sign then they will continue
//As same sign will never collide For example a=[4,7,1,1,2,-3,-7,17,15,16] 


    public static int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();//Out 
        int n = ast.length;
        for(int i = 0 ; i<n ; i++){
            if(ast[i]>0 ){
                st.push(ast[i]);
            }else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(ast[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(ast[i])){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0){
                    st.push(ast[i]);
                }
            }
        }
        int [] ans = new int[st.size()];
        for(int i = ans.length-1;i>=0;){
            ans[i--] = st.pop();
        }
        return ans;
    }
}
