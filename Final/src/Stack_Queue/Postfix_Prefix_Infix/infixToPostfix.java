class Solution {
    
    private static boolean isOperand(char c){
        if((c >= 'a' && c <= 'z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
            return true;
        }else{
            return false;
        }
    }
    
    private static int priority(char c){
        if( c == '^'){
            return 3;
        }else if (c == '*' || c == '/'){
            return 2;
        }else if (c == '+' || c == '-'){
            return 1;
        }else{
            return 0;
        }
    }
    
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder ans = new StringBuilder("");
        int i = 0; int n = s.length();
        Stack<Character> st = new Stack<>();
        
        while(i < n){
            char cur = s.charAt(i);
            
            if(isOperand(cur)){
                ans.append(cur);
            }else if(cur == '('){
                st.push(cur);
            }else if(cur == ')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans.append(st.pop());
                }
                st.pop();
            }else{
                //Operand so we will have to maintain associativity and precedence
                while(!st.isEmpty() && ((cur == '^' && priority(st.peek()) > priority(cur))
                || (cur != '^' && priority(st.peek()) >= priority(cur)))){
                    ans.append(st.pop());
                }
                //We added the equality operatore so that if the operator is +,-,/,* we will have the left most opertor be executed first
                // We did not add the equality here in order to maintain the right associativity of the power like a^b^c == a^(b^c)
                st.push(cur);
            }
            
            i++;
        }
        
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
        return ans.toString();
        
    }
}
