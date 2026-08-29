class Solution {
    
 

       private static int priority(char c) {
           if (c == '^') {
               return 3;
           } else if (c == '*' || c == '/') {
               return 2;
           } else if (c == '+' || c == '-') {
               return 1;
           } else {
               return 0;
           }
       }

       public static String infixToPostfix(String s) {
           StringBuilder ans = new StringBuilder();
           Stack<Character> st = new Stack<>();

           for (int i = 0; i < s.length(); i++) {
               char cur = s.charAt(i);

               // 1. Corrected operand condition
               if (Character.isLetterOrDigit(cur)) {
                   ans.append(cur);
               } else if (cur == '(') {
                   st.push(cur);
               } else if (cur == ')') {
                   while (!st.isEmpty() && st.peek() != '(') {
                       ans.append(st.pop());
                   }
                   if (!st.isEmpty()) st.pop(); // Remove '('
               } else { // Operator (+, -, *, /, ^)
                   // 2 & 3. Handle precedence and associativity
                   while (!st.isEmpty() && (
                       (cur != '^' && priority(st.peek()) >= priority(cur)) ||
                       (cur == '^' && priority(st.peek()) > priority(cur))
                   )) {
                       ans.append(st.pop());
                   }
                   st.push(cur);
               }
           }

           while (!st.isEmpty()) {
               ans.append(st.pop());
           }

           return ans.toString();
       }
   
}
