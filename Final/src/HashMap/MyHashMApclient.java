
public class MyHashMApclient {
    public static void main(String[] args) {
        MyHashMAp x = new MyHashMAp(5);
        x.put("Mohan", 67);
        x.put("Aman", 89);
        x.put("Rahul", 056);
        System.out.println(x.get("Mohan"));
        System.out.println(x.get("Aman"));
        x.put("Mohan", 0);
        System.out.println(x.get("Mohan"));
    }
}
