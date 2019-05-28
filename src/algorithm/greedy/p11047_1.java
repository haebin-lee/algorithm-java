package algorithm.greedy;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11047
 * */
public class p11047_1 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), value = sc.nextInt();
		int [] coins = new int[n];
		for(int i=0; i<n ; i++){
			coins[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i=n-1; i>=0 ; i--){
			ans +=value / coins[i];
			value %= coins[i];
		}
		System.out.println(ans);
	}
}
