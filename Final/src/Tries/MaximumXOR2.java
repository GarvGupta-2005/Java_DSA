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

	public static void insert(int num){
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
		return maxNum;
	}


}

    

public class MaximumXOR2 {
    public int findMaximumXOR(int[] nums) {

        Trie tr = new Trie();

        for(int x : nums){
            tr.insert(x);
        }

        int max = 0;
        for(int i = 0;i<nums.length;i++){
            max = Math.max(max,tr.getMax(nums[i]));
        }
        return max;
    }

}
