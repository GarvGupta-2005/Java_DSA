package Graph.MST;

import java.util.*;

public class AccountsMerge {
    //The Observation here is that we have to connect the accounts which have atleast one
    //common email This can be related to connecting different componenets
    //Union by Rank on the basis of emails 
    

private List<List<String>> accMerge(
        List<List<String>> details) {
        // code here
        int n = details.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> mapMailNode = new HashMap<>();
        
        //Linking the nodes if they are seen at some place 
        for(int i = 0;i<n;i++){
            for(int j = 1;j<details.get(i).size();j++){
                String mail = details.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail,i);
                }else{
                    ds.unionBySize(i,mapMailNode.get(mail));
                }
            }
        }
        
        List<String> []  mergedMail = new ArrayList[n];
        for(int i = 0;i<n;i++){
            mergedMail[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> it : mapMailNode.entrySet()){
            String mail  = it.getKey();
            int par = ds.findParent(it.getValue());
            mergedMail[par].add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
        
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        return accMerge(accounts);
    }
}
