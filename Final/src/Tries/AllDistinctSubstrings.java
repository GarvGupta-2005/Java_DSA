class Node{
    Node links [] = new Node[26];
    boolean flag = false;
    public Node(){}
    
    boolean containsKey(char a){
        return links[a-'a']!=null;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void put(char ch,Node node){
        links[ch-'a'] = node;
    }
    
    void setFlag(){
        this.flag = true;
    }
}


public class AllDistinctSubstrings 
{

	public static int countDistinctSubstrings(String st) 
	{
		//	  Write your code here.
		 int cnt = 0;
       Node root = new Node();
       for(int i = 0;i<st.length();i++){
           Node node = root;
           
           for(int j = i;j<st.length();j++){
               if(!node.containsKey(st.charAt(j))){
                   node.put(st.charAt(j),new Node());
                   cnt++;
               }
               node = node.get(st.charAt(j));
           }
       }
       return cnt+1;
      
	}
}