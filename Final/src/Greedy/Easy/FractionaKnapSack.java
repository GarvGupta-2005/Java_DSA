package Greedy.Easy;

import java.util.*;

public class FractionaKnapSack {

    class Pair implements Comparable<Pair>{//This will Store The value/weight and its initial full  capacity
        double v_w;
        int full;
        int amount;
        Pair(double  v_w,int full,int amount){
            this.v_w = v_w;
            this.full = full;
            this.amount = amount;
        }

        public int compareTo(Pair o){
            if(this.v_w>o.v_w){
                return -1;  //To Sort the array according to decreasing order of weight/value;
            }
            else if(this.v_w == o.v_w) return  0;
            else{
                return  1;
            }
        }
    }


    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        double ans = 0;
        ArrayList<Pair> fin = new ArrayList<>();
        for(int i=0;i<val.size();i++){
            int cur_val = val.get(i);
            int cur_weight = wt.get(i);
            double curv_w = (double)cur_val/cur_weight;
            fin.add(new Pair(curv_w, cur_weight,cur_val));
        }
        Collections.sort(fin);
        for(int i = 0;i<fin.size();i++){
            if(capacity>=fin.get(i).full){
                ans += fin.get(i).amount;
                capacity-=fin.get(i).full;
            }else{
                ans += fin.get(i).v_w * capacity;
                break;
            }
        }
        return  ans;
    }
}
