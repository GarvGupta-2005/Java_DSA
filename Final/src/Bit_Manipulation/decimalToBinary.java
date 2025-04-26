package Bit_Manipulation;

import java.util.Scanner;

public class decimalToBinary {
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number ");
        int n = s.nextInt();
        System.out.println("Enter the base");
        int b = s.nextInt();
        int ans = 0;
        int placevalue = 1;
        while(n>0){
            int rem = n%b;
            ans = ans + rem*placevalue;
            placevalue=placevalue*10;
            n/=b;
        }
        System.out.println("The Binary conversion is:"+ans);
        s.close();
    }

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
}
