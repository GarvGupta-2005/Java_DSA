package LinkedList.Double;

import java.util.ArrayList;


public class pairSum {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, DNode head) {
        // code here
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        if(head==null || head.next == null){
            return arr;
        }
        DNode first = head;
        DNode last = head;
        while(last.next!=null){
            last = last.next;
        }
        int cur_sum  = 0;
        
        while(first!=null && last!=null && first!=last && first.prev!=last){
             cur_sum = first.data + last.data;
            if(cur_sum == target){
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(first.data);
                cur.add(last.data);
                arr.add(cur);
                first = first.next;
                last  = last.prev;
            }
            else if(cur_sum<target){
                first = first.next;
            }
            else{
                last = last.prev;
            }
        }
        return arr;
    }
}
