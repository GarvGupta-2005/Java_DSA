package Array.Easy;

public class missingNo {
    public static int missingNumber(int []a, int N) {
        // Write your code here.
        int actsum = (N*(N+1))/2;
        int expcsum = 0;
        for(int i = 0;i<a.length;i++){
            expcsum+=a[i];
        }
        return actsum-expcsum;
    }
}
