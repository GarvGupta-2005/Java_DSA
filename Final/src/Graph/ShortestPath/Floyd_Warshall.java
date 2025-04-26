package Graph.ShortestPath;

public class Floyd_Warshall {
//     matrix[i][j] =min(matrix[i][j], matrix[i ][k]+matrix[k][j]), where i = source node,
//                   j = destination node and k = the node via which we are reaching from i to j.


public void shortestDistance(int[][] matrix) {
    // Code here
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == -1) {
                matrix[i][j] = (int)(1e9);
            }
            if (i == j) matrix[i][j] = 0;
        }
    }

    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.min(matrix[i][j],
                                        matrix[i][k] + matrix[k][j]);
            }
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == (int)(1e9)) {
                matrix[i][j] = -1;
            }
        }
    }
}


// O(v*Elog(V))

//How to detect negative cycle
//Ans: for(int i = 0 ; i<n ;i++){
// if(cost[i][i] < 0 ){  //cost[i][i] must be 0
//Then there exists a negative cycle 
//}
//}


}
