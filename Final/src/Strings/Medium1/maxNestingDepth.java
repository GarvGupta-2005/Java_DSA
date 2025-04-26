package Strings.Medium1;

public class maxNestingDepth {
    public static int maxDepth(String s) {
        int ans = 0;
        int cur_ans = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                cur_ans++;
                ans = Math.max(ans,cur_ans);
            }else if(s.charAt(i)==')'){
                cur_ans--;
                ans = Math.max(ans,cur_ans);
            }else{
                continue;
            }
        }
        return ans;
    }
}
