package Stack_Queue.MonoTonicStack_Questions;

import java.util.Stack;

public class sumOfsubarrayMinimums {
    // The brute force approach is to generate all the subarrays and then get the minimum from them and sum it.
    // This would take exponential time complexity as to generate subarrays, we need O(n^2) operations, like in this pseudocode:
    // int sum = 0;
    // for (int i = 0; i < n; i++) {
    //     int min = a[i];
    //     for (int j = i; j < n; j++) {
    //         min = Math.min(min, a[j]);
    //         sum += min;
    //     }
    // }
    
    // The most optimal approach is to find the contribution of each element in the sum.
    // That is, determine how many times one particular element appears as the minimum in the subarrays.
    // The trick is to check each side of the element to see for how many subarrays it is the minimum.

    // For instance, in the array a = [1, 4, 6, 7, 3, 7, 8, 1], for 3 to be the minimum element, 
    // subarrays like [4, 6, 7, 3] and [3, 7, 8] can be taken.
    // Therefore, the total subarrays having 3 as the minimum are 4 * 3 = 12,
    // and the contribution of 3 is 12 * 3 = 36.

    // Find indices of the next smaller elements
    public static int[] nextSmallerElementIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // If the stack is empty, the next smaller element does not exist, so use arr.length
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    // Find indices of the previous smaller elements
    public static int[] previousSmallerElementIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // If the stack is empty, the previous smaller element does not exist, so use -1
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    // Calculate the sum of subarray minimums
    public static int sumSubarrayMins(int[] arr) {
        // The Previous Smaller Element (PSE) and Next Smaller Element (NSE) indices are used to calculate contributions.
        // For instance, for 3 in the array [1, 4, 6, 7, 3, 7, 8, 1], 
        // the next smaller element comes at index 7 and the previous smaller element comes at index 0.
        // The 3 is at index 4. Thus:
        // left = 4 - 0 = 4, right = 7 - 4 = 3
        // Total subarrays = 4 * 3 = 12, and contribution = 12 * 3 = 36

        int[] nextSmaller = nextSmallerElementIndex(arr);
        int[] prevSmaller = previousSmallerElementIndex(arr);
        long total = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < arr.length; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            total = (total + (left * right % mod) * arr[i] % mod) % mod;
        }
        return (int) total;
    }



    //Another variation of this problem is sum of subarray ranges which is sumSubarrayMax(arr) - sumSubarrayMin(arr) that is we have to define a function
    //Similar to sumSubarrayMin but for opposite task i.e two new functions nextGreaterElementIndex(arr) & previousGreaterElemenetIndex(arr)

    public static int[] nextGreaterElementIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    // Find indices of the previous greater elements
    public static int[] previousGreaterElementIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    // Calculate the sum of subarray maximums
    public static int sumSubarrayMaxs(int[] arr) {
        int[] nextGreater = nextGreaterElementIndex(arr);
        int[] prevGreater = previousGreaterElementIndex(arr);
        long total = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < arr.length; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            total = (total + (left * right % mod) * arr[i] % mod) % mod;
        }
        return (int) total;
    }
}
