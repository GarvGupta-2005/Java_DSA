package Greedy.Easy;
import java.util.*;
public class AssignCokkies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int i = 0,j=0;
        int ans  = 0;
        while(i<n && j<m){
            if(g[i] <= s[j]){
                i++;
                j++;
                ans++;
            }else{
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] g = {1,2,3};
        int [] s = {1,2};
        System.out.println(findContentChildren(g, s));
    }
}
