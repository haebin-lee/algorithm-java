package algorithm.search;

import java.util.Scanner;

public class p9095 {
	
	/**
	 * https://www.acmicpc.net/problem/9095
	 * */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();

		for(int i=0; i<testcase ; i++){
			int n = sc.nextInt();
			int ans = dp(n);
			System.out.println(ans);
		}
	}

	private static int dp(int n) {
		if(n==1){
			return 1;
		}else if(n==2){
			return 2;
		}else if(n==3){
			return 4;
		}
		return dp(n-3)+dp(n-2)+dp(n-1);
	}
}
