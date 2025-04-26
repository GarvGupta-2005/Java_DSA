package Graph.Other;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
    //This is an algo to determine the strongly connected componenets of a graph
    //Strongly connected components are only for directed graph

    // Function to find number of strongly connected components in the graph.
    //This is a very intutive piece of code 
    //Here we reverse the entire nodes or connections in the graph
    //The Observations is that if the directions are reversed in a stromg componenet
    //Then also we can reach other nodes and other sc but if a non-sc is reverse
    //We can't reach any
    
    
    //Step 1 : Sort all the edges according to finishing time
    //Step 2 : Reverse the graph
    //Step 3 : Perform the dfs
    
    
    private void dfs(int node,int [] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer>st){
        
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it]!= 1){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);//Typical tpop sort
    }
    
    private void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, adjT);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.

    
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (Integer it : adj.get(i)) {
                // i -> it
                // it -> i
                adjT.get(it).add(i);//Reversing the graph step
            }
        }
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {  //Again doing dfs to check the nodes of the strong components
                scc++;   //The nodes that are already visited will not be an individual sc
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    

    }
}
