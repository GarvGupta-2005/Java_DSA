
class Solution {
    
    static void insertAtBottom(Stack<Integer> s,int temp){
        if(s.isEmpty()){
            s.push(temp);
            return;
        }
        
        int val = s.pop();
        insertAtBottom(s,temp);
        s.push(val);
    }
    
    static void reverse(Stack<Integer> s) {
        // add your code here
        if(s.size()==1){
            return;
        }
        int temp = s.pop();
        reverse(s);
        insertAtBottom(s,temp);
    }
}
