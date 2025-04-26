package Stack_Queue.MonoTonicStack_Questions;

import java.util.*;

public class Max_Sliding_Windows {
// We initially keep a left and right pointer to fix our window to a size of k. We compute the maximum element present in this window using the 
// GetMax function. Further, update the left and right pointer by left++ and right++ every time to get to a new window of size k using a while 
// loop. For every new window we encounter, we add the maximum element using the GetMax function to our data structure.

static void GetMax(int arr[], int l, int r, ArrayList < Integer > maxx) {
        int i, maxi = Integer.MIN_VALUE;
        for (i = l; i <= r; i++)
            maxi = Math.max(maxi, arr[i]);
        maxx.add(maxi);
    }
    static ArrayList < Integer > maxSlidingWindow(int arr[], int k) {
        int left = 0, right = 0;
        ArrayList < Integer > maxx = new ArrayList < > ();
        while (right < k - 1) {
            right++;
        }
        while (right < arr.length) {
            GetMax(arr, left, right, maxx);
            left++;
            right++;
        }
        return maxx;
    }
    //But this is not  good as TC is O(n-k)*k as we have to travese till n-k windows and then look for max in  window;

    //The optimised Approach is as follows
    // We address this problem with the help of a data structure that keeps checking whether the incoming element is larger than the already 
    // present elements. This could be implemented with the help of a de-queue. When shifting our window, we push the new element in from the 
    // rear of our de-queue. Following is a sample representation of our dequeue
    // Every time before entering a new element, we first need to check whether the element present at the front is out of bounds of our 
    // present window size. If so, we need to pop that out. Also, we need to check from the rear that the element present is smaller than the 
    // incoming element. If yes, there’s no point storing them and hence we pop them out. Finally, the element present at the front would be 
    // our largest element.

    //Note: we can only generate windows till n-k indices where k is size of window as after this the window will exceed the array 
    public int[] maxSlidingWindow1(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
