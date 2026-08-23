class Solution {
    
    private int[] Sieve(int n){
        int [] prime = new int[n+1];
        Arrays.fill(prime,1);
        prime[0] = 0;
        prime[1] = 0;
        
        for(int i = 2;i*i <= n;i++){
            if(prime[i] == 1){
                for(int j = i*i;j<=n;j += i){
                    prime[j] = 0;
                }
            }
        }
        
        return prime;
        
    }
    
    public List<Integer> primeRange(int l, int r) {
        // code here
        
        int [] prime = Sieve(r);
        List<Integer> ans = new ArrayList<>();
        
        for(int i = l;i<=r;i++){
            if(prime[i] == 1){
                ans.add(i);
            }
        }
        
        return ans;
        
    }
}
