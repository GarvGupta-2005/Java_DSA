import java.util.ArrayList;

class Node{
	Node [] links = new Node[2];//Since  bits have ony 2 values 0 or 1

	public Node(){}

	boolean containsKey(int ind){
		return links[ind]!= null;
	}

	Node get(int ind){
		return links[ind];
	}

	void put(int ind,Node node){
		links[ind] = node;
	}
}

class Trie{
	private static Node root;

	Trie(){
		root = new Node();
	}

	public  void insert(int num){
		Node node = root;
		for(int i = 31;i>=0;i--){
			int bit = ((num >> i) & 1);
			if(!node.containsKey(bit)){
				node.put(bit,new Node());
			}
			node = node.get(bit);
		}
	}

	public int getMax(int num){
		Node node = root;
		int maxNum = 0;
		for(int i = 31;i>=0;i--){
			int bit = ((num >> i) & 1);
			if(node.containsKey(1-bit)){
				maxNum = (maxNum | (1<<i));
				node = node.get(1-bit);
			}else{
				node = node.get(bit);
			}
		}
        return  maxNum;
	}


}


public class MaximumXOR1{
    //Simple trick is to inser the elements of one array in a trie and then check all the other elements 
	//of second array for maximum XOR this will be the whole scenario for the whole problem
	public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) 
	{
	    // Write your code here.  
		Trie trie = new Trie();
		for(Integer x : arr1){
			trie.insert(x);
		}
		int maxi = 0;
		for(int i = 0;i<m;i++){
			maxi = Math.max(maxi,trie.getMax(arr2.get(i)));
		}
		return maxi; 
	}
}