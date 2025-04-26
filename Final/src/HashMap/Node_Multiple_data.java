
class Node{
    String x;
    int data;
    Node(String x,int data){
        this.x = x;
        this.data = data;
    }
}
public class Node_Multiple_data {
    public static void main(String[] args) {
        Node [] arr = new Node[5];
        for(int i = 0 ; i < 5;i++){
            arr[i] = new Node("s", i);
        }
    }
}
