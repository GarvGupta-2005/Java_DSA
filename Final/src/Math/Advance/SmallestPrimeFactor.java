class Solution {
    private int [] SmallestPrimeFactor (int n){
        int SPF[] = new int[n+1];
        
        for(int i = 0;i<=n;i++){
            SPF[i] = i;
        }
        
        for(int i = 2;i*i<=n;i++){
            if(SPF[i] == i){
                for(int j = i*i;j<=n;j+=i){
                    if(SPF[j]==j){
                        SPF[j] = i;
                    }
                }
            }
        }
        
        return SPF;
    }
    
    public int[] leastPrimeFactor(int n) {
        // code here
        return SmallestPrimeFactor(n);
    }
}
