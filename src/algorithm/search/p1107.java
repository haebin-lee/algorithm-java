package algorithm.search;

import java.util.Scanner;

public class p1107 {
	
	/**
	 * https://www.acmicpc.net/problem/1107
	 * */
	static boolean [] broken = new boolean[10];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt(), n = sc.nextInt();
		for(int i =0; i<n ;i++){
			broken[sc.nextInt()] = true;
		}
		
		// 초기값은 100 +/-를 누르는 갯수
		int ans = Math.abs(input-100);
		
		for(int i=0; i<=1000000 ; i++){
			int c = i;
			int len = possible(c);
			// 해당길이만큼 이동 가능
			if(len>0){
				//  몇번 +,- 를 눌러야 하는지 확인
				int press = Math.abs(c-input);
				
				if(ans>len+press){
					ans = len+press;
				}	
			}
		}
		System.out.println(ans);
		
		sc.close();
		
	}
	private static int possible(int c) {
		// c==0일때에는 아래의 while문 적용이 안됨
		if(c==0)
			return broken[0]? 0 : 1;
		
		int len =0; 
		while(c>0){
			// 맨끝자리수가 고장났는지 확인
			if(broken[c%10]) return 0;
			c/=10;
			len++; //길이 체크
		}
		return len;
	}
}
