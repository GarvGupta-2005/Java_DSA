package Stack_Queue.Intro;

import java.util.Stack;

public class balanceParenthesis {
    public static boolean isValid(String S) {
        Stack<Character> st = new Stack<>();
        int rem1 = 0; 
        int rem2 = 0; 
        int rem3 = 0;
        for(int i = 0 ; i < S.length(); i++){
            if(S.charAt(i)=='('){
                st.push('(');
                rem1++;
            }
            else if(S.charAt(i)=='{'){
                st.push('{');
                rem2++;
            }
            else if(S.charAt(i)=='['){
                st.push('[');
                rem3++;
            }
            else{
                if(st.size()==0){
                    return false;
                }
                else if(S.charAt(i)==')'&& st.peek()=='('){
                    st.pop();
                    rem1--;
                }
                else if(S.charAt(i)=='}'&& st.peek()=='{'){
                    st.pop();
                    rem2--;
                }
                else if(S.charAt(i)==']'&& st.peek()=='['){
                    st.pop();
                    rem3--;
                }
                else{
                    return false;
                }
            }

        }
       if(rem1>0 || rem2>0 || rem3>0){
            return false;
        }else{
            return true;
        }
    }

    //Another version of my code is 
    public static boolean isValid1(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false;
                char ch = st.pop(); 
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }

}

