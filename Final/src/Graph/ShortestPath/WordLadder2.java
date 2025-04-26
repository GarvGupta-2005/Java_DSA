package Graph.ShortestPath;

import java.util.*;

public class WordLadder2 {
    class Solution {
        public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                          String targetWord,
                                                          String[] wordList) {
            Set<String> st = new HashSet<>(Arrays.asList(wordList));
    
            Queue<ArrayList<String>> q = new LinkedList<>();
            ArrayList<String> ls = new ArrayList<>();
            ls.add(startWord);
            q.add(ls);
    
            Set<String> usedOnLevel = new HashSet<>();
            usedOnLevel.add(startWord);
            int level = 0;
    
            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            int cnt = 0;
    
            while (!q.isEmpty()) {
                cnt++;
                ArrayList<String> vec = q.poll();
    
                if (vec.size() > level) {
                    level++;
                    for (String it : usedOnLevel) {
                        st.remove(it);
                    }
                    usedOnLevel.clear();
                }
    
                String word = vec.get(vec.size() - 1);
    
                if (word.equals(targetWord)) {
                    if (ans.isEmpty() || ans.get(0).size() == vec.size()) {
                        ans.add(new ArrayList<>(vec));
                    } else {
                        break;
                    }
                }
    
                for (int i = 0; i < word.length(); i++) {
                    char[] replacedCharArray = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        replacedCharArray[i] = c;
                        String replacedWord = new String(replacedCharArray);
                        if (st.contains(replacedWord)) {
                            vec.add(replacedWord);
                            q.add(new ArrayList<>(vec));
                            usedOnLevel.add(replacedWord);
                            vec.remove(vec.size() - 1);
                        }
                    }
                }
            }
            return ans;
        }
    }
}
