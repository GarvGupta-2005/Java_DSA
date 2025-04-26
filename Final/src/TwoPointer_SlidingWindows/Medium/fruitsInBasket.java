package TwoPointer_SlidingWindows.Medium;

import java.util.HashMap;

public class fruitsInBasket {
    //Longest sub array containing only two distinct elements

// User function Template for Java

    public static int totalElements(Integer[] arr) {
        // code here
        int l=0,r=0,maxi=0;
        int n=arr.length;
        HashMap<Integer,Integer> h= new HashMap<>();
        
        
        while(r<n && l<n)
        {
            h.put(arr[r],h.getOrDefault(arr[r],0)+1);
            
            while(h.size()>2)
            {
                h.put(arr[l],h.get(arr[l])-1);
                if(h.get(arr[l])==0)
                   h.remove(arr[l]);
                 l++;
            
                
            }
            
            
            
            
            
            
         if(h.size()<=2)
         {
             maxi=Math.max(maxi,r-l+1);
             
            
           
         }
            r++;
        }
        return maxi;
    }

}