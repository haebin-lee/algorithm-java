package algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11399
 * */
public class p11399_1 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] atm = new int[n];
		for(int i=0 ;i <n ; i++){
			atm[i] = sc.nextInt();
		}
		Arrays.sort(atm);
		
		int ans = 0; 
		for(int i=0; i< n ; i++){
			ans += atm[i] * (n-i);
		}
		System.out.println(ans);
	}
}
