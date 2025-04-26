package CustomSort;

import java.util.*;

class cmo implements Comparator<Product>{
    public int compare(Product o1 , Product o2){
        if(o1.price<o2.price){
            return -1;
        }else{
            return 1;
        }
    }
}
public class Client {
    public static void main(String[] args) {
        Product p1 = new Product("apple", 50000);
        Product p2 = new Product("samsun", 60000);
        Product p3 = new Product("nokia", 10000);
        Product p4 = new Product("oppo", 23000);
        ArrayList<Product> arr  = new ArrayList<>();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);
        Collections.sort(arr);
        for(Product x:arr){
            System.out.println(x.name + " " + x.price);
        }
    }
}
