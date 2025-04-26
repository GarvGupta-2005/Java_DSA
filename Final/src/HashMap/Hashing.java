
public class Hashing {
    public static int hashFunction(String S){
        //Mapping karne mei help kar raha hai String ko Integer ke sath
        //specific value range mei [0,21]
        int hashValue = S.hashCode();
        int Map = Math.abs(hashValue)%21;
        return Map;
    }
    public static void main(String[] args) {
        // String s = "Hello";
        // System.out.println(s.hashCode()%5);//the function used to find the hash function answer
        // Integer x = 23;
        // System.out.println(x.hashCode());
        System.out.println(hashFunction("GarvGupta$$"));
    }
}
