package Heap.Hard;
import java.util.*;


public class MedianDataStream {
    
}
 class MedianFinder {

    //Basically we dive the coming input in two halves such that one store in reverse order so that we can access two elements if the 
    //size is even and one element if the size is odd thus making the operations faster 
    private PriorityQueue<Integer> leftMaxHeap; // max heap
    private PriorityQueue<Integer> rightMinHeap; // min heap

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        // always maintain leftMaxHeap size one greater than rightMinHeap size
        // or both sizes equal
        if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            // even number of elements
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }

        // odd number of elements
        return leftMaxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */