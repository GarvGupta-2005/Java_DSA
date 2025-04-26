package Graph.ShortestPath;

import java.util.*;

class Pair{
    String first;
    int second;
    Pair(String f,int s){
        this.first = f;
        this.second = s;
    }
}

public class WordLadder1 {
    
    
    
        //This Approach will follow a Level Order Approach where we will keep changinge word
        //Until we reach a word that is present in the list 
        //And ultimately we reach the target word 
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<Pair> q = new LinkedList<>();
            Set<String> s = new HashSet<>();
            int len = wordList.size();
            for(int i = 0;i<len;i++){
                s.add(wordList.get(i));
            }
            s.remove(beginWord);
            q.add(new Pair(beginWord,1));
            while(!q.isEmpty()){
                String word = q.peek().first;
                int steps = q.peek().second;
    
                if(word.equals(endWord)==true)return steps;
                q.remove();
                for(int i = 0;i<word.length();i++){
                    for(char c = 'a';c<='z';c++){
                        char replacedArray [] = word.toCharArray();
                        replacedArray[i] = c;
                        String newWord = new String(replacedArray);
                        if(s.contains(newWord)){
                            s.remove(newWord);
                            q.add(new Pair(newWord,steps+1));
                        }
                    }
                }
            }
            return 0;
        }
    }
