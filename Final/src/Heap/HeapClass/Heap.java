package Heap.HeapClass;

import java.util.ArrayList;

class Heap<T extends Comparable<T>> {

  private ArrayList<T> list;

  public Heap() {
    list = new ArrayList<>();
  }

  private void swap(int first, int second) {
    T temp = list.get(first);
    list.set(first, list.get(second));
    list.set(second, temp);
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private int left(int index) {
    return index * 2 + 1;
  }
  
  private int right(int index) {
    return index * 2 + 2;
  }

  public void insert(T value) {
    list.add(value);
    upheap(list.size() - 1);
  }
  private void upheap(int index) {
    if(index == 0) {
      return;
    }
    int p = parent(index);
    if(list.get(index).compareTo(list.get(p)) < 0) { //This means that the value of parent is  greater than this child then swap
      swap(index, p);
      upheap(p);
    }
  }

  public T remove() throws Exception {
    if (list.isEmpty()) {
      throw new Exception("Removing from an empty heap!");
    }

    T temp = list.get(0);

    T last = list.remove(list.size() - 1);
    if (!list.isEmpty()) {
      list.set(0, last);
      downheap(0);
    }
    
    return temp;
  }
  private void downheap(int index) {
    int min = index;
    int left = left(index);
    int right = right(index);

    if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {//The left index child is smaller than our current min then min is left
      min = left;
    }

    if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
      min = right;
    }

    if(min != index) {
      swap(min, index);
      downheap(min);
    }
  }

  public ArrayList<T> heapSort() throws Exception {
    ArrayList<T> data = new ArrayList<>();
    while(!list.isEmpty()) {
      data.add(this.remove());
    }
    return data;
  }
}


import java.util.*;

class Heap<T> {
    private ArrayList<T> heap;
    private Comparator<T> comparator;

    Heap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(T ele) {
        heap.add(ele);
        upheapify(heap.size() - 1);
    }

    private int getParent(int ind) {
        return (ind - 1) / 2;
    }

    private int getLeftIndex(int ind) {
        return 2 * ind + 1;
    }

    private int getRightIndex(int ind) {
        return 2 * ind + 2;
    }

    private void swap(int ind1, int ind2) {
        T temp = heap.get(ind1);
        heap.set(ind1, heap.get(ind2));
        heap.set(ind2, temp);
    }

    private void upheapify(int ind) {
        if (ind == 0) return;

        int parent = getParent(ind);

        // If parent should come "after" child according to comparator, swap
        if (comparator.compare(heap.get(parent), heap.get(ind)) > 0) {
            swap(ind, parent);
            upheapify(parent);
        }
    }

    public T remove() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        T top = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheapify(0);
        }

        return top;
    }

    private void downheapify(int ind) {
        int left = getLeftIndex(ind);
        int right = getRightIndex(ind);
        int best = ind;

        if (left < heap.size() && comparator.compare(heap.get(left), heap.get(best)) < 0) {
            best = left;
        }
        if (right < heap.size() && comparator.compare(heap.get(right), heap.get(best)) < 0) {
            best = right;
        }

        if (best != ind) {
            swap(ind, best);
            downheapify(best);
        }
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}

class Main {
    public static void main(String[] args) {
        // Min heap of integers
        Heap<Integer> minHeap = new Heap<>((a, b) -> a - b);
        minHeap.add(5);
        minHeap.add(1);
        minHeap.add(9);
        minHeap.add(3);
        System.out.println("Min heap peek: " + minHeap.peek()); // 1

        // Max heap of integers
        Heap<Integer> maxHeap = new Heap<>((a, b) -> b - a);
        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(9);
        maxHeap.add(3);
        System.out.println("Max heap peek: " + maxHeap.peek()); // 9

        // Custom object heap - Students by age (min heap)
        Heap<Student> studentHeap = new Heap<>(Comparator.comparing(s -> s.age));
        studentHeap.add(new Student("Alice", 25));
        studentHeap.add(new Student("Bob", 19));
        studentHeap.add(new Student("Carol", 30));
        System.out.println("Youngest: " + studentHeap.peek().name); // Bob

        // Drain min heap to verify sorted order comes out
        System.out.print("Min heap order: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.remove() + " ");
        }
        System.out.println();
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
