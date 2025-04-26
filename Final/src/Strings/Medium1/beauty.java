package Strings.Medium1;
public class beauty {
        //Calssic brute approach to get all substrings and then find beauty 
        public int getMin(int [] freq){
            int minn = Integer.MAX_VALUE;
            for(int i = 0;i<freq.length;i++){
                if(freq[i]!=0){
                    minn = Math.min(minn,freq[i]);
                }
            }
            return minn;
        }
        public int getMax(int [] freq){
            int maxx = Integer.MIN_VALUE;
            for(int i = 0;i<freq.length;i++){
                if(freq[i]!=0){
                    maxx = Math.max(maxx,freq[i]);
                }
            }
            return maxx;
        }
        public int beautySum(String s) {
            int sum   = 0;
            for(int i  = 0 ; i<s.length();i++){
                int [] freq = new int[26];
                for(int j  = i; j<s.length();j++){
                    freq[s.charAt(j)-'a']++;
                    int beauty = getMax(freq) - getMin(freq);
                    sum+=beauty;
                }
            }
            return sum;
        }
    
}
