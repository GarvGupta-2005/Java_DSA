package Heap.Medium;


import java.util.*;
public class hands {
    
    //This question will be solved by mkaking an object that stores the value and its frequency
        //We will insert the objects into the pq and if thier frequncies is greater than 1 we will store the object in a queue as well
    //So when one group is complete then we can add the remaining freuencies in the pq again
    //Ths will go until the pq is mpty and the question will be solved
    
    class Card{
        int card;
        int count;
        Card(int val,int count){
            this.card = val;
            this.count = count;
        }
    }
    
        public boolean isNStraightHand(int[] hand, int groupSize) {
            if(hand.length%groupSize!=0) return false;//Since we won't be able to make groups from all the elements
            if(groupSize == 1) return true;
    
            PriorityQueue<Card> pq = new PriorityQueue<>(new Comparator<>() {
                public int compare(Card c1 , Card c2){
                    return Integer.compare(c1.card,c2.card);
                }
            });
    
            Map<Integer,Integer> map  =new HashMap<>();
            for(int i : hand){
                map.put(i,map.getOrDefault(i,0)+1);
            }//Setting their frequncies
    
            //Adding Cards to pq
    
            for(int key : map.keySet()){
                pq.add(new Card(key,map.get(key)));
            }
    
            while(!pq.isEmpty()){
                Card c = pq.remove();
                Queue<Card> q = new LinkedList<>();
                c.count--;
                for(int i = 1;i<groupSize;i++){
                    if(!pq.isEmpty() && c.card + i == pq.peek().card){
                        Card curr = pq.remove();
                        curr.count--;
                        if(curr.count>=1){
                            q.add(curr);
                        }
                    }else return false;
                }
                while(!q.isEmpty()){
                    pq.add(q.remove());
                }
                if(c.count>=1){
                    pq.add(c);
                }
            }
            return true;
    
        }
    
}
