
import java.util.*;
 class Point{
    int x ; int y ;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Demo_For_Multiple_data {
    // public static void main(String[] args) {
    //     Point [] array = new Point[5];
    // for(int i = 0;i<5;i++){
    //     array[i] = new Point(i, i);
    // }
    // System.out.println(array[0].x);
    // System.out.println(array[0].y);
    // }
    public static void main(String[] args) {
        LinkedList<Integer> [] arr = new LinkedList[5]; // Array of LinkedList
        LinkedList<Point> [] arr1 = new LinkedList[5];  // Array of LinkedList having Point as object;
        for(int i = 0 ; i < 5;i++){
            arr[i] = new LinkedList<>();
            System.out.println(arr[i]);
        }

    }
}

