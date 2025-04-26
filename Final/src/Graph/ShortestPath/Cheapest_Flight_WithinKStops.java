package Graph.ShortestPath;
import java.util.*;

class Pair{
    int first,second;
    Pair(int f,int s){
        this.first = f; this.second = s;
    }
}

class Tuple{
    int first,second,third;
    Tuple(int f,int s,int t){
        this.first = f; this.second = s; this.third = t;
    }
}
public class Cheapest_Flight_WithinKStops {
    //Here we have to compute shortest distance in terms of minimum stops 
    //not minimum distance so that is one major difference here 
    
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        //Step 1 Create The Graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        
        Queue<Tuple> q = new LinkedList<>();
        //The First element in tuple stores the no. of stops, the second stores the src
        //and the third stores the distance
        q.add(new Tuple(0,src,0));
        
        int [] dist = new int[n];
        for(int i = 0;i<n;i++){
            dist[i] = (int)1e9;
        }
        dist[src] = 0;
        
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove(); 
            int stops = it.first; 
            int node = it.second; 
            int cost = it.third; 
            
            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue; 
            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first; 
                int edW = iter.second; 
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW; 
                    q.add(new Tuple(stops + 1, adjNode, cost + edW)); 
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst]; 
    }
}
    
    
    
