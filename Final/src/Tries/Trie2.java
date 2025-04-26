package Tries;

class Node{
    private Node [] links = new Node[26];
    private int cntEndWith = 0;
    private int cntPrefix = 0;
    
    public Node(){}

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Returns the child node corresponding to the given character
    Node get(char ch) {
        return links[ch - 'a'];
    }

    // Creates a link between current node and given character
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void increaseEnd(){
        this.cntEndWith++;
    }

    void increasePrefix(){
        this.cntPrefix++;
    }

    void deleteEnd(){
        this.cntEndWith--;
    }

    void reducePrefix(){
        this.cntPrefix--;
    }
    
    int getEnd(){
        return this.cntEndWith;
    }
    int getPrefix(){
        return this.cntPrefix;
    }
}

public class Trie2 {

    private Node root;

    public Trie2() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            }else{
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            }else{
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }else{
                return;
            }
        }
        node.deleteEnd();
    }

}
