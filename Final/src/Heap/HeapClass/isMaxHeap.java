package Heap.HeapClass;

public class isMaxHeap {
    public static boolean countSub(long[] arr, long n)
    { for(int i=0;i<n;i++){
        if(((i*2)+1 < n && arr[i] < arr[(i*2)+1]) || ( (i*2)+2 < n && arr[i]<arr[(i*2)+2])){
            return false;
        }
    }
    return true;
        // Your code goes here
    }
}
