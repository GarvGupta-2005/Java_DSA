package Recursion.Basic;
import java.util.*;
public class reverseStack {
      public static void main(String[] args) {
         Stack<Integer> stack = new Stack<>();
         stack.push(1);
         stack.push(2);
         stack.push(3);
         reverse(stack);
         System.out.println(stack);
      }
      public static void reverse(Stack<Integer> stack) {
         if(stack.isEmpty()) return;
         int temp = stack.pop();
         reverse(stack);
         insertAtBottom(stack, temp);
      }
      public static void insertAtBottom(Stack<Integer> stack, int temp) {
         if(stack.isEmpty()) {
               stack.push(temp);
               return;
         }
         int val = stack.pop();
         insertAtBottom(stack, temp);
         stack.push(val);
      }
}