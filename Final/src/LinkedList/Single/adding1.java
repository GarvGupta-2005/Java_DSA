package LinkedList.Single;

public class adding1 {
    public static int addHelper(Node temp){
		if(temp==null){
			return 1;
		}
		int carry = addHelper(temp.next);
		temp.data += carry;
		if(temp.data<10){
			return 0;
		}
		temp.data = 0;
		return 1;
	}
	public static Node addOne(Node head) {
		// Write your code here.
		int carry = addHelper(head);
		if(carry==1){
			Node newNode = new Node(1);
			newNode.next = head;
			return newNode;
		}
		return head;
	}
}
