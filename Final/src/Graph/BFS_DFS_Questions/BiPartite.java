package Graph.BFS_DFS_Questions;

import java.util.*;

public class BiPartite {
    //A graph is bipartit that if we can paint its nodes with 2 colors and no adjacent nodes have same color
    //Linear and even cycled graphs are always bipartite
    //Odd cycled graphs are not bipartied 

    private boolean BFScheck(int start,int V,int [][] graph,int [] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            int [] adj = graph[node];//taking the djacency list of this node
            for(int i = 0;i<adj.length;i++){
     //If the adjacent node is not colored we will give it the opposite color of the node
                if(color[adj[i]]==-1){
                    color[adj[i]] = 1-color[node];
                    q.add(adj[i]);
                }
                else if(color[adj[i]]==color[node]){//adjacent nodes can't have same color
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int [] color = new int[V];
        Arrays.fill(color,-1);
        for(int i = 0;i<V;i++){
            if(color[i]==-1){
                if(BFScheck(i,V,graph,color)==false){
                    return false;
                }
            }
        }
        return true;
    }

    //This is using DFS 
    private boolean DFScheck(int node,int col,int [] color,int [][]graph){
        color[node] = col;
        int [] adj = graph[node];
        for(int i = 0;i<adj.length;i++){
            if(color[adj[i]]==-1){//Uncolored node found
            if(DFScheck(adj[i],1-col,color,graph)==false){
                return false;
            }
            }
            else if(color[adj[i]]==col){
                return false;
            }
        }
        return true;
      }
        public boolean isBipartite1(int[][] graph) {
            int V = graph.length;
            int [] color = new int[V];
            Arrays.fill(color,-1);
            for(int i = 0;i<V;i++){
                if(color[i]==-1){
                    if(!DFScheck(i,0,color,graph)) return false;
                }
            }
            return true;
        }
}
