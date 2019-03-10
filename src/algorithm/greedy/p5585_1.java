package algorithm.greedy;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/5585
 * */
public class p5585_1 {
	
	static Scanner sc = new Scanner(System.in);
	static int standard = 1000; 
	static int [] coins = new int[] {500, 100, 50, 10, 5};
	public static void main(String[] args){
		
		int num = sc.nextInt();
		int left = standard - num; 
		int count=0;
		for(int i=0; i< coins.length; i++){
			count += left / coins[i];
			left %= coins[i];
		}
		System.out.println(count);
	}
}
