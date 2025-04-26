package Bit_Manipulation;

public class OneCompliment {
    public static StringBuilder convert2Binary(int n){
        String res = "";
        while(n!=1){
            if(n%2==1){
                res = res + 1;  //The complexity will be O(logn) as we keep dividing it by 2 in each iteration
            }else{
                res = res + 0;
            }
            n = n/2;
        }
        StringBuilder sb = new StringBuilder(res);
        return sb.reverse();
    }
    public static String oneComplement(int n){
        StringBuilder sb = convert2Binary(n);
        String ans = "";
        for(int i = 0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                ans = ans + 0;
            }else{
                ans = ans + 1;
            }
        }
        return ans;
    }
    //To find two's compliment, we add 1 to one's compliment
}
