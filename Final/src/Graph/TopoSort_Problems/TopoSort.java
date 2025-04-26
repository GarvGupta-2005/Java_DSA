package Graph.TopoSort_Problems;

import java.util.ArrayList;
import java.util.Stack;

public class TopoSort {
    //Topological Sort:- Applied in Directed Acyclic Graph; Linear ordering of vertices such 
    // that if there is an edge between u&v then u always appear before v
    private static void dfs(int node,int []vis,ArrayList<ArrayList<Integer>>adj,Stack<Integer>st){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int V = adj.size();
        int [] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,adj,st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(st.size()>0){
            ans.add(st.pop());
        }
        return ans;
    }
    
    
}
