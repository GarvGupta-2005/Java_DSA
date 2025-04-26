package Heap.HeapClass;

public class MINtoMAX {
    static void convertMinToMaxHeap(int n, int arr[]) {
        for (int i=n/2-1; i>=0; i--){
            heapify(arr,n,i);
        }
    }
    
    public static void heapify(int arr[], int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left<n && arr[left]>arr[largest]){
            largest = left;
        }
        if (right<n && arr[right]>arr[largest]){
            largest = right;
        }
        if (largest!=i){
            swap(arr,i,largest);
            heapify(arr, n, largest);
        }
    }
    
    public static void swap(int arr[], int i, int j){
        int rev = arr[i];
        arr[i]=arr[j];
        arr[j]=rev;
    }
}
