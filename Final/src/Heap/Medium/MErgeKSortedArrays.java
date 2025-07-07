class EleInfo{
     int element,arrIdx,eleIdx;
     public EleInfo(int ele,int arrid,int eleid){
         this.element = ele;
         this.arrIdx = arrid;
         this.eleIdx = eleid;
     }
 }

class Solution {
    // Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        
        PriorityQueue<EleInfo> pq =  new PriorityQueue<>((a,b)->a.element-b.element);
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0;i<K;i++){
            pq.add(new EleInfo(arr[i][0],i,0));
        }
        
        while(!pq.isEmpty()){
            EleInfo poll = pq.poll();
            int val = poll.element;
            int arrIdx = poll.arrIdx;
            int eleIdx = poll.eleIdx;
            
            ans.add(val);
            eleIdx++;
            if(eleIdx < arr[arrIdx].length){
                pq.add(new EleInfo(arr[arrIdx][eleIdx],arrIdx,eleIdx));
            }
        }
        
        return ans;
        
    }
}
