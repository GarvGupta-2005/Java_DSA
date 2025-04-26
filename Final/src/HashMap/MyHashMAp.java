
import java.util.*;
class Entry {
    String key;
    int value;
    Entry(String key , int value){
        this.key = key;
        this.value = value;
    }
}
public class MyHashMAp {
    LinkedList<Entry> [] arr;
    MyHashMAp(int x){
        arr = new LinkedList[x];
        for(int i = 0 ; i < x ;i++){
            arr[i] = new LinkedList<>(); // An array of linked list which contains "Entry" kind of data 
        }
    }
    private int hashFunction(String Key){
        int hashValue = Key.hashCode();
        return Math.abs(hashValue)%arr.length;
    }
    public boolean containsKey(String Key){
        // firstly Find the mapping value for th key 
        int index = hashFunction(Key);
        LinkedList<Entry> temp = arr[index];
        for(Entry e : temp){
            if(e.key.equals(Key)){
                return true;
            }
        }
        return false;
    }
    public void put(String Key,int valeu){
        int index = hashFunction(Key);
        LinkedList<Entry> temp = arr[index];
        if(containsKey(Key)){
            for(Entry e : temp){
                if(e.key.equals(Key)){
                    e.value = valeu;
                }
            }
        }else{
            Entry a = new Entry(Key, valeu);
            temp.add(a);
        }
      
    }
    public int get(String Key){
        int index = hashFunction(Key);
        LinkedList<Entry> temp = arr[index];
        for(Entry e : temp){
            if(e.key.equals(Key)){
                return e.value;
            }
        }
        return -1;
    }
    public void remove(String Key){
        int index = hashFunction(Key);
        LinkedList<Entry> temp = arr[index];
        for(Entry e : temp){
            if(e.key.equals(Key)){
                temp.remove(e);
            }
        }
    }
    @Override // to restrict the signature of the function 
    public String toString(){
        String ans = "[";
        for(int i = 0 ; i < arr.length;i++){
            LinkedList<Entry> list = arr[i];
            for(Entry e : list){
                ans += "{" + e.key + "=" + e.value + "}";
            }
        }
        ans +="]";
        return ans;
    }

}
