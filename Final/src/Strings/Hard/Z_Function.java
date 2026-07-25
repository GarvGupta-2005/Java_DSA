class Z_Function {
    public static int[] ZAlgorithm(String s) {
        int n = s.length();
        int[] Z = new int[n];
        
        int l = 0, r = 0; // Current rightmost segment match [l, r)
        
        for (int i = 1; i < n; i++) {
            // Step 1: Reuse precomputed Z-values if i is within [l, r)
            if (i < r) {
                Z[i] = Math.min(r - i, Z[i - l]);
            }
            
            // Step 2: Manually extend Z[i] past 'r' or from scratch
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            
            // Step 3: Update our rightmost matching segment [l, r)
            if (i + Z[i] > r) {
                l = i;
                r = i + Z[i];
            }
        }
        return Z;
    }

    public static void main(String[] args) {
        String str = "abacaba";
        int[] z = ZAlgorithm(str);
        
        for (int val : z) {
            System.out.print(val + " ");
        }
        // Output: 0 0 1 0 3 0 1
    }
}
