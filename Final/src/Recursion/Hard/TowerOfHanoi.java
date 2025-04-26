package Recursion.Hard;


import java.util.*;

public class TowerOfHanoi{
    public static void move(int n,char src,char helper,char dest){
		if(n == 0){
			return;
		}
		move(n-1,src,dest,helper);
		System.out.println("Moving ring "+ n +" from "+ src+ " to "+ dest);
		move(n-1,helper,src,dest);
	}
    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		move(n,'A','C','B');
    }
}