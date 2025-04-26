package LinkedList.Double;


class DNode {
    int data;
    DNode next;
    DNode prev;

    DNode(int data,DNode next,DNode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    DNode(int data){
        this.data = data;
        this.next = null;
        this.prev  = null;
    }
}
public class Create {
    class Solution {
    DNode constructDLL(int arr[]) {
        // Code here
        DNode head = new DNode(arr[0]);
        DNode temp = head;
        for(int i = 1;i<arr.length;i++){
            DNode cur = new DNode(arr[i]);
            temp.next = cur;
            cur.prev = temp;
            temp = cur;
        }
        return head;
    }
}
}
