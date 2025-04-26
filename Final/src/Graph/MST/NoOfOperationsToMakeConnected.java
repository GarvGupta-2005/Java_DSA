package Graph.MST;

public class NoOfOperationsToMakeConnected {
    public int makeConnected(int n, int[][] edge) {
        // Code here
        //We will see how many componentes are there in total and how many extra edges are there 
        //if we can connect those componentes with extra edges then we return them else -1'
        DisjointSet ds = new DisjointSet(n);
        int cntExtra = 0;
        int m = edge.length;
        for(int i = 0;i<m;i++){
            int u = edge[i][0];
            int v = edge[i][1];
            if(ds.findParent(u) == ds.findParent(v)){
                cntExtra++;//Since they have same parent then  count this edge extra
            }else{
                ds.unionByRank(u,v);
            }
        }
        //Now Count the componenets
        int comp = 0;
        for(int i = 0;i<n;i++){
            if(ds.findParent(i) == i){
                comp++;
            }
        }
        int ans = comp - 1;
        if(cntExtra>= ans){
            return ans;
        }
        return -1;
    }    
}
