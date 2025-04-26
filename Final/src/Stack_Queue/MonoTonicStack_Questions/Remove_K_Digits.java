package Stack_Queue.MonoTonicStack_Questions;

import java.util.Stack;

public class Remove_K_Digits {
    
   

         //this involves greedy thinking of removing K largest digits from the number

    //A few Edge Cases of this problem are:
//If k == num.length then return "0"
//If in the remaining num have trailing zeroes then remove trailing zeroes as "00100"  should be returned as "100"
// 


    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0"; // If all digits are removed, return "0"
        }

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            // Remove larger digits when the current digit is smaller
            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        // If any removals are still left, remove from the top of the stack
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Construct the result from the stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        // Reverse to get the correct order
        sb.reverse();

        // Remove leading zeroes
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If the result is empty, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }


}
