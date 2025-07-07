//First we greedily check that can we even traverse the circuit by checking the sum 
//Then we start from each station and check from where we can traverse the whole 

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tgas = 0;
        int tcost = 0;
        for(int i = 0;i<gas.length;i++){
            tgas  += gas[i];
            tcost += cost[i];
        }
        if(tgas<tcost)return -1;

        int total = 0;
        int start = 0;
        for(int i = 0;i<gas.length;i++){
            total += gas[i] - cost[i];
            if(total<0){
                total = 0;
                start = i+1;
            }
        }
        if(start == gas.length)start = 0;
        return start;
    }
}
