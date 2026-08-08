class Solution {
    private int Solve(int discs, int From, int To,int Helper){
        if(discs == 0 || discs == 1){
            return discs;
        }
        
        int ans = 0;
        ans += Solve(discs-1,From,Helper,To);//Move n-1 discs from From to Helper with help of To 
        ans += 1; //Move nth disc from From to To;
        ans += Solve(discs-1,Helper,To,From);//Move the rest remaining n-1 discs from Helper to To using the empty From rod  
        return ans;
    }
    
    
    
    public int towerOfHanoi(int n, int from, int to, int aux) {
        // code here
        
        return Solve(n,from,to,aux);
    }
}
