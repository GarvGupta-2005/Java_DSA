package CustomSort;
public class Product implements Comparable<Product>{
    String name;                        //Custom sorrting to sort the products this will only be done when ur buckets can be compare
    int price;
    Product(String name,int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public int compareTo(Product o) {
        if(this.price<o.price){
            return -1;
        }else{
            return 1;
        }
    }
}
