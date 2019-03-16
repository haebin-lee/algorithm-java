package algorithm.greedy;

import java.util.Scanner;

public class p2875 {
	
	/**
	 * https://www.acmicpc.net/problem/2875
	 * */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// n은 여자/m은 남자/ k는 인턴쉽 참가자수 여:남 = 2:1
		int n= sc.nextInt(), m=sc.nextInt(), k=sc.nextInt();
		
		int total = n+m;
		int result =0; 
		while(m>0){
//			System.out.println(m);
			if(m*2<=n && m*3 <=total-k){
				result=m;
				break;
			}
			m--;
		}
		System.out.println(result);
	}
}
