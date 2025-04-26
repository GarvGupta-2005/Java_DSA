package Graph.BFS_DFS_Questions;

import java.util.ArrayList;

public class ProvincesCount {
      private static void dfs(int node,ArrayList<ArrayList<Integer>> adjl,int [] visited){
        
        visited[node] = 1;
        for(Integer it : adjl.get(node)){
            if(visited[it]==0){
                dfs(it,adjl,visited);
            }
        }
    }
    
    
    
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        // code here
        //Converting Adjacency Matrix to Adjacency List 
        ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
        for(int i = 1;i<=v;i++){
            adjl.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<v;i++){
            for(int j = 0;j<v;j++){
                if(adj.get(i).get(j) == 1 && i!=j){
                    adjl.get(i).add(j);
                    adjl.get(j).add(i);
                }
            }
        }
        int [] visited = new int[v];
        int count = 0;
        for(int i = 0;i<v;i++){
            if(visited[i] == 0){
                count++;
                dfs(i,adjl,visited);
            }
        }
        
        return count;
    }

    public static int findCircleNum(int[][] adj) {
        int v = adj.length;

        ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
        for(int i = 1;i<=v;i++){
            adjl.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<v;i++){
            for(int j = 0;j<v;j++){
                if(adj[i][j] == 1 && i!=j){
                    adjl.get(i).add(j);
                    adjl.get(j).add(i);
                }
            }
        }
        int [] visited = new int[v];
        int count = 0;
        for(int i = 0;i<v;i++){
            if(visited[i] == 0){
                count++;
                dfs(i,adjl,visited);
            }
        }
        
        return count;
    }
}
