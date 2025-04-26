package Bit_Manipulation;

import java.util.Scanner;

public class binaryToDecimal {
     public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number ");
        int n = s.nextInt();
        int ans = 0;
        int placevalue = 1;
        while(n>0){
           int rem = n%10;
           ans += rem*placevalue;
           placevalue=placevalue*2;
           n=n/10;
        }
        System.out.println("The decimal  conversion is:"+ans);
    }
    public static int convert2Decimal(String x){
        int ans = 0;
        int n = x.length();
        int power = 1;
        for(int i = n-1;i>=0;i--){
            if(x.charAt(i)=='1'){
                ans += power;
                power *= 2;
            }
        }
        return ans;
    }
}
